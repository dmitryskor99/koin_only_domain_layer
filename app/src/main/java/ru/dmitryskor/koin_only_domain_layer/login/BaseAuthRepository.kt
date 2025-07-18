package ru.dmitryskor.koin_only_domain_layer.login

class BaseAuthRepository(
    private val authDataStore: AuthDataStore
) : AuthRepository {

    override fun onSingIn() = authDataStore.onSingIn()

    override fun onLogout() = authDataStore.onLogout()
}