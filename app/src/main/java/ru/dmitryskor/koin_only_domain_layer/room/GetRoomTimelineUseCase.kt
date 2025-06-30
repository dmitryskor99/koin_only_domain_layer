package ru.dmitryskor.koin_only_domain_layer.room

class GetRoomTimelineUseCase(
    private val timelineRepository: TimelineRepository
) {

    operator fun invoke(roomIndex: Int): RoomTimeline  = timelineRepository.getRoomTimeline(roomIndex)
}