package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper

class ChatToUiMapper : Mapper.DataMapper.ChatMapper<ChatUi> {
    override fun map(id: Long, name: String, lastNote: String): ChatUi {
        return ChatUi(id, name, lastNote)
    }
}