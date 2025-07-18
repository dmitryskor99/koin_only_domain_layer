package ru.dmitryskor.koin_only_domain_layer.login

interface AuthRepository {
    fun onSingIn()
    fun onLogout()
}