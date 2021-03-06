package ru.kiz.developer.abdulaev.notesaschat.data.mapper

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity

class ChatDomainToDataMapper : Mapper.ChatMapper<ChatEntity> {
    override fun map(id: Long, name: String, lastNote: String): ChatEntity {
        return ChatEntityForMap(id, name)
    }

    private class ChatEntityForMap(
        override var id: Long,
        override val name: String
    ) : ChatEntity
}