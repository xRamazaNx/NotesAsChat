package ru.kiz.developer.abdulaev.notesaschat.data

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper

class ChatDomainToDataMapper : Mapper.DataMapper.ChatMapper<ChatEntity> {
    override fun map(id: Long, name: String, lastNote: String): ChatEntity {
        return ChatEntityForMap(id, name)
    }

    private class ChatEntityForMap(
        override var id: Long,
        override val name: String
    ) : ChatEntity
}