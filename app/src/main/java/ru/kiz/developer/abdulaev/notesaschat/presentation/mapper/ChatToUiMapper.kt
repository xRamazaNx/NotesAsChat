package ru.kiz.developer.abdulaev.notesaschat.presentation.mapper

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatUi

class ChatToUiMapper : Mapper.DataMapper.ChatMapper<ChatUi> {
    override fun map(id: Long, name: String, lastNote: String): ChatUi {
        return ChatUi(id, name, lastNote)
    }
}