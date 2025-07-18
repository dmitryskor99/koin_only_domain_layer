package ru.dmitryskor.koin_only_domain_layer.login

import kotlinx.coroutines.flow.StateFlow

interface SignInRepository {
    fun isSignInNow(): StateFlow<Boolean>
}