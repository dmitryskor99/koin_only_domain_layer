package ru.dmitryskor.koin_only_domain_layer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import ru.dmitryskor.koin_only_domain_layer.login.LoginScreen
import ru.dmitryskor.koin_only_domain_layer.login.OnSingInUseCase

@Composable
fun AuthNavigation(
    modifier: Modifier = Modifier,
    onSign: OnSingInUseCase
) {
    val authStack = rememberNavBackStack<AuthNavigationKey>(Login)

    NavDisplay(
        modifier = modifier,
        backStack = authStack,
        entryProvider = entryProvider {
            entry<Login> {
                LoginScreen(
                    onSign = onSign
                )
            }
        }
    )
}

interface AuthNavigationKey : NavKey

@Serializable
data object Login : AuthNavigationKey