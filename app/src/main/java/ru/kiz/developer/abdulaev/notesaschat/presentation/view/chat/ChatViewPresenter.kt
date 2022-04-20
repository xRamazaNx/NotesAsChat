package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface ChatViewPresenter : Presenter.ViewPresenter {
    fun setName(name: String)
    fun setLastNote(note: String)
}