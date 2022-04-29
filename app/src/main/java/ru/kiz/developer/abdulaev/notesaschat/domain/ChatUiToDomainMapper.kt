package ru.kiz.developer.abdulaev.notesaschat.domain

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat

class ChatUiToDomainMapper : Mapper.DataMapper.ChatMapper<Chat> {
    override fun map(id: Long, name: String, lastNote: String): Chat {
        return Chat(id, name, lastNote)
    }
}