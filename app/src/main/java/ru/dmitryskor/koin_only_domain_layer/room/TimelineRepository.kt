package ru.dmitryskor.koin_only_domain_layer.room

interface TimelineRepository {
    fun getRoomTimeline(roomIndex: Int): RoomTimeline
}