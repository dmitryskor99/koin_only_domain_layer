package ru.dmitryskor.koin_only_domain_layer.login

class OnLogoutUseCase(
    private val authRepository: AuthRepository
) {

    operator fun invoke() = authRepository.onLogout()
}