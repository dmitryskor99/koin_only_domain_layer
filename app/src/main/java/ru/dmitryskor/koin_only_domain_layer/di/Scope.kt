package ru.dmitryskor.koin_only_domain_layer.di

sealed interface MyScope {
    val name: String
}

object AuthScope : MyScope {
    override val name = "auth_scope_id"
}

object RoomScope : MyScope {
    override val name = "room_scope_id"
}

object SessionScope : MyScope {
    override val name = "session_scope_id"
}