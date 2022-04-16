package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder

class ChatViewBinder(
    private val chatViewBinding: ChatViewBinding
) : Binder.DataBinder.ChatBinder {
    override fun bind(name: String, lastNoteStr: String) {
        chatViewBinding.chatName.text = name
        chatViewBinding.lastNote.text = lastNoteStr
    }
}