package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface ChatPresenter : Presenter {
    fun setName(name: String)
    fun setLastNote(note: String)
}