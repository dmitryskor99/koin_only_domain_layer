package ru.dmitryskor.koin_only_domain_layer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import ru.dmitryskor.koin_only_domain_layer.Client
import ru.dmitryskor.koin_only_domain_layer.room.RoomScreen
import ru.dmitryskor.koin_only_domain_layer.roomList.RoomListScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
) {
    val nonAuthStack = rememberNavBackStack<AppNavigationKey>(RoomList)

    NavDisplay(
        modifier = modifier,
        backStack = nonAuthStack,
        entryProvider = entryProvider {
            entry<RoomList> {
                Client.roomOut()
                RoomListScreen(getRooms = Client.getGetRoomsUseCase()) {
                    nonAuthStack.add(Room(it))
                }
            }
            entry<Room> {
                Client.onRoom()
                RoomScreen(
                    getRoomTimeline = Client.getGetRoomTimelineUseCase(),
                    indexRoom = it.roomIndex,
                    onLogout = Client.getOnLogoutUseCase()
                )
            }
        }
    )
}

interface AppNavigationKey : NavKey

@Serializable
data object RoomList : AppNavigationKey

@Serializable
data class Room(val roomIndex: Int) : AppNavigationKey