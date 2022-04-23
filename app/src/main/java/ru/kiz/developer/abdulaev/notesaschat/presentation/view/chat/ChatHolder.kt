package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class ChatHolder(view: View) : AbstractHolder<Chat>(view), Binder.DataBinder.ChatBinder {
    private val binding = ChatViewBinding.bind(view)

    override fun bindHolder(t: Chat, clickListener: ClickListener<Chat>) {
        super.bindHolder(t, clickListener)
        t.bind(this)
    }

    override fun bind(id: Long, name: String, lastNoteStr: String) {
        binding.chatName.text = name
        binding.lastNote.text = lastNoteStr
    }
}