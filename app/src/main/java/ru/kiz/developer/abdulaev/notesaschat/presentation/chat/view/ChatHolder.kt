package ru.kiz.developer.abdulaev.notesaschat.presentation.chat.view

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class ChatHolder(
    view: View
) : AbstractHolder<ChatUi, ChatViewWrapper>(view) {
    override val viewWrapper = ChatViewWrapper(ChatViewBinding.bind(view))

    override fun bindHolder(t: ChatUi, clickListener: ClickListener<ChatUi>) {
        super.bindHolder(t, clickListener)
        t.map(viewWrapper)
    }
}