package ru.dmitryskor.koin_only_domain_layer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import ru.dmitryskor.koin_only_domain_layer.roomList.RoomListScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val nonAuthStack = rememberNavBackStack<AppNavigationKey>(RoomList)

    println("iuwehf nonAuthStack = $nonAuthStack")

    NavDisplay(
        modifier = modifier,
        backStack = nonAuthStack,
        entryProvider = entryProvider {
            entry<RoomList> {
                RoomListScreen()
            }
        }
    )
}

interface AppNavigationKey : NavKey

@Serializable
data object RoomList : AppNavigationKey