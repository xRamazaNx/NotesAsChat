package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class ChatHolder(
    binding: ChatViewBinding
) : AbstractHolder<Chat, ChatViewBinding>(binding) {
    override fun bind(t: Chat, clickListener: ClickListener<Chat>) {
        super.bind(t, clickListener)
        t.bind(ChatViewBinder(binding))
    }
}