package ru.kiz.developer.abdulaev.notesaschat.presentation.chat.view

import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.utils.inflate

class ChatAdapter(
    clickListener: AbstractHolder.ClickListener<ChatUi>
) : AbstractAdapter<ChatUi, ChatHolder>(clickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatHolder {
        val chatView = parent.context.inflate(R.layout.chat_view)
        return ChatHolder(chatView)
    }
}