package ru.dmitryskor.koin_only_domain_layer.login

import kotlinx.coroutines.flow.StateFlow

interface AuthDataStore {
    fun isSignInNow(): StateFlow<Boolean>
    fun onSingIn()
    fun onLogout()
}