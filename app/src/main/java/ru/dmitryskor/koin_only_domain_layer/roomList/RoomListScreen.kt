package ru.dmitryskor.koin_only_domain_layer.roomList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoomListScreen(
    modifier: Modifier = Modifier,
    getRooms: GetRoomsUseCase
) {
    val rooms = getRooms().collectAsState()

    RoomListContent(
        rooms = rooms.value
    )
}

@Composable
private fun RoomListContent(
    modifier: Modifier = Modifier,
    rooms: List<Room>
) {
    LazyColumn {
        items(rooms) { room ->
            RoomItem(room = room)
        }
    }
}

@Composable
private fun RoomItem(
    modifier: Modifier = Modifier,
    room: Room
) {
    Column(
        modifier = modifier
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