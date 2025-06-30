package ru.dmitryskor.koin_only_domain_layer.roomList

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BaseRoomsRepository : RoomsRepository {
    override fun getAllRooms(): StateFlow<List<Room>> {
        return MutableStateFlow(
            listOf(
                Room(0, "Новости", "Путин хороший!"),
                Room(1, "Семейный чат", "Заберите меня(("),
                Room(2, "Чат подъезда", "Курят на балокне!!!!")
            )
        )
    }
}