package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface NoteViewPresenter : Presenter.ViewPresenter {
    fun setBody(body: String)
}