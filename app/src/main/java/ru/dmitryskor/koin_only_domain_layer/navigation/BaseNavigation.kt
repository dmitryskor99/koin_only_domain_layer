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
import ru.dmitryskor.koin_only_domain_layer.login.IsLoginUseCase
import ru.dmitryskor.koin_only_domain_layer.login.OnSingInUseCase
import ru.dmitryskor.koin_only_domain_layer.roomList.GetRoomsUseCase

@Composable
fun BaseNavigation(
    modifier: Modifier = Modifier,
    isLogin: IsLoginUseCase,
    onSign: OnSingInUseCase,
    getRooms: GetRoomsUseCase
) {
    val isLoginState = isLogin().collectAsState()

    val appStack = rememberNavBackStack<BaseNavigationKey>(if (isLoginState.value) Auth else NonAuth)

    if (isLoginState.value) {
        appStack[0] = Auth
    } else {
        appStack[0] = NonAuth
    }

    NavDisplay(
        modifier = modifier,
        backStack = appStack,
        entryProvider = entryProvider {
            entry<NonAuth> {
                AuthNavigation(
                    onSign = onSign
                )
            }
            entry<Auth> {
                AppNavigation(getRooms = getRooms)
            }
        }
    )
}

interface BaseNavigationKey : NavKey

@Serializable
data object NonAuth : BaseNavigationKey

@Serializable
data object Auth : BaseNavigationKey