package ru.dmitryskor.koin_only_domain_layer.login

import kotlinx.coroutines.flow.StateFlow

class BaseSignInRepository(
    private val authDataStore: AuthDataStore
) : SignInRepository {
    override fun isSignInNow(): StateFlow<Boolean> = authDataStore.isSignInNow()
}