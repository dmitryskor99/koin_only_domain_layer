package ru.dmitryskor.koin_only_domain_layer.roomList

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class GetRoomsUseCase(
    private val roomsRepository: RoomsRepository
) {
    operator fun invoke(): StateFlow<List<Room>> = roomsRepository.getAllRooms()
}