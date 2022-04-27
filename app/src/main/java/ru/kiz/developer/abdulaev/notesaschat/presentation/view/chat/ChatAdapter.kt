package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.utils.inflate

class ChatAdapter(
    clickListener: AbstractHolder.ClickListener<Binder<Binder.DataBinder.ChatBinder>>
) : AbstractAdapter<Chat, ChatHolder>(ChatClickListenerWrapper(clickListener)) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatHolder {
        val chatView = parent.context.inflate(R.layout.chat_view)
        return ChatHolder(chatView)
    }

    private class ChatClickListenerWrapper(
        private val clickListener: AbstractHolder.ClickListener<Binder<Binder.DataBinder.ChatBinder>>
    ) :
        AbstractHolder.ClickListener<Chat> {
        override fun onClick(t: Chat) {
            clickListener.onClick(t)
        }
    }
}