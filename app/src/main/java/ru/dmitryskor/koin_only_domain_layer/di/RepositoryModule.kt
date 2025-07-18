package ru.dmitryskor.koin_only_domain_layer.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.scopedOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.dmitryskor.koin_only_domain_layer.login.AuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.BaseAuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.BaseSignInRepository
import ru.dmitryskor.koin_only_domain_layer.login.SignInRepository
import ru.dmitryskor.koin_only_domain_layer.room.BaseTimelineRepository
import ru.dmitryskor.koin_only_domain_layer.room.TimelineRepository
import ru.dmitryskor.koin_only_domain_layer.roomList.BaseRoomsRepository
import ru.dmitryskor.koin_only_domain_layer.roomList.RoomsRepository

val repositoryModule = module {

    singleOf(::BaseSignInRepository) { bind<SignInRepository>() }
    singleOf(::BaseAuthRepository) { bind<AuthRepository>() }

    scope<RoomScope> {
        scopedOf(::BaseTimelineRepository) { bind<TimelineRepository>() }
    }
    scope<SessionScope> {
        scopedOf(::BaseRoomsRepository) { bind<RoomsRepository>() }
    }
}