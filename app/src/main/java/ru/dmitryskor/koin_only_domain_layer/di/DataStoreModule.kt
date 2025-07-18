package ru.dmitryskor.koin_only_domain_layer.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.dmitryskor.koin_only_domain_layer.login.AuthDataStore
import ru.dmitryskor.koin_only_domain_layer.login.LocalAuthDataStore

val dataStoreModule = module {
    singleOf(::LocalAuthDataStore) { bind<AuthDataStore>() }
}