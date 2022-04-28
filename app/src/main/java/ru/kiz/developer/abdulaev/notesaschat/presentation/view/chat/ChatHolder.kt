package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.ChatUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class ChatHolder(
    view: View
) : AbstractHolder<ChatUi, ChatViewWrapper>(view), Binder.DataBinder.ChatBinder {
    override val viewWrapper = ChatViewWrapper.Base(ChatViewBinding.bind(view))

    override fun bindHolder(t: ChatUi, clickListener: ClickListener<ChatUi>) {
        super.bindHolder(t, clickListener)
        t.bind(this)
    }

    override fun bind(id: Long, name: String, lastNoteStr: String) {
        viewWrapper.setName(name)
        viewWrapper.setLastNote(lastNoteStr)
    }
}