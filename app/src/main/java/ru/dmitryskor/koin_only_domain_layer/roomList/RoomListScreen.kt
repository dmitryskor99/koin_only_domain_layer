package ru.dmitryskor.koin_only_domain_layer.roomList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoomListScreen(
    modifier: Modifier = Modifier,
    getRooms: GetRoomsUseCase,
    onClickRoom: (Int) -> Unit
) {
    val rooms = getRooms().collectAsState()

    RoomListContent(
        rooms = rooms.value,
        onClickRoom = onClickRoom
    )
}

@Composable
private fun RoomListContent(
    modifier: Modifier = Modifier,
    rooms: List<Room>,
    onClickRoom: (Int) -> Unit
) {
    LazyColumn {
        items(rooms.size) { roomIndex ->
            RoomItem(room = rooms[roomIndex]) {
                onClickRoom(roomIndex)
            }
        }
    }
}

@Composable
private fun RoomItem(
    modifier: Modifier = Modifier,
    room: Room,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = room.name,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = room.lastMessage,
            fontSize = 12.sp
        )
    }
}