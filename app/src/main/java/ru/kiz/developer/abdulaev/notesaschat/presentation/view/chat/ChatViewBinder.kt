package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import ru.kiz.developer.abdulaev.notesaschat.domain.Binder

class ChatViewBinder(
    private val chatPresenter: ChatPresenter
) : Binder.DataBinder.ChatBinder {
    override fun bind(name: String, lastNoteStr: String) {
        chatPresenter.setName(name)
        chatPresenter.setLastNote(lastNoteStr)
    }
}