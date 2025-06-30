package ru.dmitryskor.koin_only_domain_layer.login

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    fun isSignInNow(): StateFlow<Boolean>
    fun onSingIn()
    fun onLogout()
}