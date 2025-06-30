package ru.dmitryskor.koin_only_domain_layer.login

import kotlinx.coroutines.flow.StateFlow

class IsLoginUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): StateFlow<Boolean> = authRepository.isSignInNow()
}