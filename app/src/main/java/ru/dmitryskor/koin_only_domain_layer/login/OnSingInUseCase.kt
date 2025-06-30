package ru.dmitryskor.koin_only_domain_layer.login

class OnSingInUseCase(
    private val authRepository: AuthRepository
) {

    operator fun invoke() {
        authRepository.onSingIn()
    }
}