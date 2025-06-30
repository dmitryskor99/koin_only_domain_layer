package ru.dmitryskor.koin_only_domain_layer.roomList

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface RoomsRepository {
    fun getAllRooms(): StateFlow<List<Room>>
}