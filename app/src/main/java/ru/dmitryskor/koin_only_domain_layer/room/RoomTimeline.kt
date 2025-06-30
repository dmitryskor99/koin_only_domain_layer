package ru.dmitryskor.koin_only_domain_layer.room

data class RoomTimeline(
    val messages: List<Message>
)

data class Message(
    val text: String
)
