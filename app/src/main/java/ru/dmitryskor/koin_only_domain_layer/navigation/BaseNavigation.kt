package ru.dmitryskor.koin_only_domain_layer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import ru.dmitryskor.koin_only_domain_layer.Client
import ru.dmitryskor.koin_only_domain_layer.login.IsLoginUseCase

@Composable
fun BaseNavigation(
    modifier: Modifier = Modifier,
    isLoginState: IsLoginUseCase,
) {
    val isLoginState = isLoginState().collectAsState()

    val appStack = rememberNavBackStack<BaseNavigationKey>(
        isLoginState.value?.let {
            Auth
        } ?: NonAuth
    )

    NavDisplay(
        modifier = modifier,
        backStack = appStack,
        entryProvider = entryProvider {
            entry<NonAuth> {
                Client.logout()
                AuthNavigation(
                )
            }
            entry<Auth> {
                Client.onLogin()
                AppNavigation()
            }
        }
    )
}

interface BaseNavigationKey : NavKey

@Serializable
data object NonAuth : BaseNavigationKey

@Serializable
data object Auth : BaseNavigationKey