package ru.dmitryskor.koin_only_domain_layer.login

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocalAuthDataStore : AuthDataStore {

    private val isSignIn = MutableStateFlow<Boolean>(false)

    override fun isSignInNow(): StateFlow<Boolean> = isSignIn.asStateFlow()

    override fun onSingIn() {
        isSignIn.value = true
    }

    override fun onLogout() {
        isSignIn.value = false
    }
}