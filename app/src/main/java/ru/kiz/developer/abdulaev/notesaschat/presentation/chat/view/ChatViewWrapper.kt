package ru.kiz.developer.abdulaev.notesaschat.presentation.chat.view

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.ViewWrapper

class ChatViewWrapper(
    chatViewBinding: ChatViewBinding
) : ViewWrapper(chatViewBinding.root), Mapper.DataMapper.ChatMapper<Unit> {
    private val name = chatViewBinding.chatName
    private val lastNote = chatViewBinding.lastNote
    override fun map(id: Long, name: String, lastNote: String) {
        this.name.text = name
        this.lastNote.text = lastNote
    }

}