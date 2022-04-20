package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import ru.kiz.developer.abdulaev.notesaschat.domain.Binder

class ChatViewBinder(
    private val chatViewPresenter: ChatViewPresenter
) : Binder.DataBinder.ChatBinder {
    override fun bind(name: String, lastNoteStr: String) {
        chatViewPresenter.setName(name)
        chatViewPresenter.setLastNote(lastNoteStr)
    }
}