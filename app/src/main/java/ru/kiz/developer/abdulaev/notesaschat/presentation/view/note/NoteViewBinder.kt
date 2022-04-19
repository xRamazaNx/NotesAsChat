package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import ru.kiz.developer.abdulaev.notesaschat.domain.Binder

class NoteViewBinder(
    private val notePresenter: NotePresenter
) : Binder.DataBinder.NoteBinder {
    override fun bind(body: String) {
        notePresenter.setBody(body)
    }
}