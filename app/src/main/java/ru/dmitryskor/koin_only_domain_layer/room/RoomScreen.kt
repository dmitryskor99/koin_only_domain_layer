package ru.dmitryskor.koin_only_domain_layer.room

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.dmitryskor.koin_only_domain_layer.login.OnLogoutUseCase

@Composable
fun RoomScreen(
    modifier: Modifier = Modifier,
    getRoomTimeline: GetRoomTimelineUseCase,
    onLogout: OnLogoutUseCase,
    indexRoom: Int
) {
    RoomContent(
        timeline = getRoomTimeline(indexRoom),
        onLogout = onLogout
    )
}

@Composable
private fun RoomContent(
    modifier: Modifier = Modifier,
    onLogout: OnLogoutUseCase,
    timeline: RoomTimeline
) {
    Column {
        Button(
            onClick = {
                onLogout()
            }
        ) { }

        LazyColumn {
            items(timeline.messages) { message ->
                MessageItem(message = message)
            }
        }
    }
}

@Composable
private fun MessageItem(
    modifier: Modifier = Modifier,
    message: Message
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = message.text
    )
}