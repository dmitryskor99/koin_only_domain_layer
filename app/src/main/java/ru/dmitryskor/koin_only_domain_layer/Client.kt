package ru.dmitryskor.koin_only_domain_layer

import ru.dmitryskor.koin_only_domain_layer.login.AuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.BaseAuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.IsLoginUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnSingInUseCase
import ru.dmitryskor.koin_only_domain_layer.roomList.BaseRoomsRepository
import ru.dmitryskor.koin_only_domain_layer.roomList.GetRoomsUseCase
import ru.dmitryskor.koin_only_domain_layer.roomList.RoomsRepository

object Client {

    private val authRepository: AuthRepository = BaseAuthRepository()
    private val roomsRepository: RoomsRepository = BaseRoomsRepository()

    fun getIsLoginUseCase(): IsLoginUseCase {
        return IsLoginUseCase(authRepository)
    }

    fun getOnSingInUseCase(): OnSingInUseCase {
        return OnSingInUseCase(authRepository)
    }

    fun getGetRoomsUseCase(): GetRoomsUseCase {
        return GetRoomsUseCase(roomsRepository)
    }
}