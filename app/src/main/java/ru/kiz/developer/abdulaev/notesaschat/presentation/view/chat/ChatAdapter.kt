package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.utils.DiffUtilCallback
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class ChatAdapter(
    clickListener: AbstractHolder.ClickListener<Chat>
) : AbstractAdapter<Chat, ChatViewBinding, ChatHolder>(clickListener, DiffUtilCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatHolder {
        val inflater = LayoutInflater.from(parent.context)
        val chatView = inflater.inflate(R.layout.chat_view, parent, false)
        return ChatHolder(chatView)
    }

}