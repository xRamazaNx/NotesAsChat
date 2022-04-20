package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class ChatHolder(view: View) : AbstractHolder<Chat>(view), ChatViewPresenter {
    private val binding = ChatViewBinding.bind(view)

    override fun bind(t: Chat, clickListener: ClickListener<Chat>) {
        super.bind(t, clickListener)
        t.bind(ChatViewBinder(this))
    }

    override fun setName(name: String) {
        binding.chatName.text = name
    }

    override fun setLastNote(note: String) {
        binding.lastNote.text = note
    }
}