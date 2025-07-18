package ru.dmitryskor.koin_only_domain_layer.di

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.dmitryskor.koin_only_domain_layer.login.IsLoginUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnLogoutUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnSingInUseCase
import ru.dmitryskor.koin_only_domain_layer.room.GetRoomTimelineUseCase
import ru.dmitryskor.koin_only_domain_layer.roomList.GetRoomsUseCase

val useCaseModule = module {

    factoryOf(::IsLoginUseCase)
    factoryOf(::OnLogoutUseCase)

    scope<AuthScope> {
        factoryOf(::OnSingInUseCase)
    }
    scope<RoomScope> {
        factoryOf(::GetRoomTimelineUseCase)
    }
    scope<SessionScope> {
        factoryOf(::GetRoomsUseCase)
    }
}