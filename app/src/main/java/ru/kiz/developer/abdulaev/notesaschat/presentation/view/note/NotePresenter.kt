package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface NotePresenter : Presenter {
    fun setBody(body: String)
}