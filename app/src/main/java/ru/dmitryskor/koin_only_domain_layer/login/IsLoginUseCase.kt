package ru.dmitryskor.koin_only_domain_layer.login

import kotlinx.coroutines.flow.StateFlow

class IsLoginUseCase(
    private val signInRepository: SignInRepository
) {
    operator fun invoke(): StateFlow<Boolean> = signInRepository.isSignInNow()
}