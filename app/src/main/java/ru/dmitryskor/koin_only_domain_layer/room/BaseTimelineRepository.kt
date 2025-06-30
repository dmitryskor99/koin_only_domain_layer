package ru.dmitryskor.koin_only_domain_layer.room

class BaseTimelineRepository : TimelineRepository {
    override fun getRoomTimeline(roomIndex: Int): RoomTimeline {
        return when (roomIndex) {
            0 -> {
                RoomTimeline(listOf(
                    Message("Путин"),
                    Message("Путин х"),
                    Message("Путин хор"),
                    Message("Путин хороший!")
                ))
            }
            1 -> {
                RoomTimeline(listOf(
                    Message("Нас пригласили на день рождения!"),
                    Message("Мы поедем после работы"),
                    Message("Я дома"),
                    Message("Заберите меня((")
                ))
            }
            2 -> {
                RoomTimeline(listOf(
                    Message("Курят на балокне!!!!"),
                    Message("Курят на балокне!!!!"),
                    Message("Козлы!!!!"),
                    Message("Курят на балокне!!!!"),
                    Message("Курят на балокне!!!!")
                ))
            }
            else -> throw Exception()
        }
    }
}