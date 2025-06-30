package ru.dmitryskor.koin_only_domain_layer

import ru.dmitryskor.koin_only_domain_layer.login.AuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.BaseAuthRepository
import ru.dmitryskor.koin_only_domain_layer.login.IsLoginUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnSingInUseCase

object Client {

    private val authRepository: AuthRepository = BaseAuthRepository()

    fun getIsLoginUseCase(): IsLoginUseCase {
        return IsLoginUseCase(authRepository)
    }
    fun getOnSingInUseCase(): OnSingInUseCase {
        return OnSingInUseCase(authRepository)
    }
}