package ru.kiz.developer.abdulaev.notesaschat.data

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper

class NoteDomainToDataMapper(
    private val chatId: Long
) : Mapper.DataMapper.NoteMapper<NoteEntity> {

    override fun map(id: Long, body: String): NoteEntity {
        return NoteEntityForMap(id = id, chatId = chatId, body = body)
    }

    private class NoteEntityForMap(
        override var id: Long,
        override val chatId: Long,
        override val body: String
    ) : NoteEntity
}