package ru.dmitryskor.koin_only_domain_layer

import org.koin.java.KoinJavaComponent.getKoin
import ru.dmitryskor.koin_only_domain_layer.di.AuthScope
import ru.dmitryskor.koin_only_domain_layer.di.MyScope
import ru.dmitryskor.koin_only_domain_layer.di.RoomScope
import ru.dmitryskor.koin_only_domain_layer.di.SessionScope
import ru.dmitryskor.koin_only_domain_layer.login.IsLoginUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnLogoutUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnSingInUseCase
import ru.dmitryskor.koin_only_domain_layer.room.GetRoomTimelineUseCase
import ru.dmitryskor.koin_only_domain_layer.roomList.GetRoomsUseCase

object Client {

    private val koin get() = getKoin()

    private val authScope get() = koin.getScope(AuthScope.name)
    private val sessionScope get() = koin.getScope(SessionScope.name)
    private val roomScope get() = koin.getScope(RoomScope.name)

    private inline fun <reified T : MyScope> createScope(scope: T) {
        koin.getScopeOrNull(scope.name) ?:
        koin.createScope<T>(scope.name)
    }

    private fun createAuthScope() = createScope(AuthScope)
    private fun createSessionScope() {
        createScope(SessionScope)
    }
    private fun createRoomScope() = createScope(RoomScope)

    private fun <T : MyScope> closeScope(scope: T) {
        koin.getScopeOrNull(scope.name)?.close()
    }

    // non using
    private fun closeAuthScope() = closeScope(AuthScope)
    private fun closeSessionScope() = closeScope(SessionScope)
    private fun closeRoomScope() = closeScope(RoomScope)

    fun onRoom() {
        println("kwjerbfnkjwefbn открыли скоуп комнаты")
        createRoomScope()
    }

    fun roomOut() {
        println("kwjerbfnkjwefbn закрыли скоуп комнаты")
        closeRoomScope()
    }

    fun onLogin() {
        closeAuthScope()
        createSessionScope()
    }

    fun logout() {
        println("kwjerbfnkjwefbn закрыли session скоуп и открыли auth")
//        closeSessionScope()
        createAuthScope()
    }

    fun getIsLoginUseCase(): IsLoginUseCase = koin.get()

    fun getOnLogoutUseCase(): OnLogoutUseCase = koin.get()

    fun getOnSingInUseCase(): OnSingInUseCase = authScope.get()

    fun getGetRoomsUseCase(): GetRoomsUseCase = sessionScope.get()

    fun getGetRoomTimelineUseCase(): GetRoomTimelineUseCase = roomScope.get()
}