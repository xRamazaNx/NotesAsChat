package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.presentation.ChatUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.utils.inflate

class ChatAdapter(
    clickListener: AbstractHolder.ClickListener<Binder<Binder.DataBinder.ChatBinder>>
) : AbstractAdapter<ChatUi, ChatHolder>(ChatClickListenerWrapper(clickListener)) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatHolder {
        val chatView = parent.context.inflate(R.layout.chat_view)
        return ChatHolder(chatView)
    }

    private class ChatClickListenerWrapper(
        private val clickListener: AbstractHolder.ClickListener<Binder<Binder.DataBinder.ChatBinder>>
    ) : AbstractHolder.ClickListener<ChatUi> {
        override fun onClick(t: ChatUi) {
            clickListener.onClick(t)
        }

        override fun onLongClick(t: ChatUi) {
            clickListener.onClick(t)
        }
    }
}