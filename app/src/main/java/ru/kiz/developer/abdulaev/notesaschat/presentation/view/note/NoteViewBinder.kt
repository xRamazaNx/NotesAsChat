package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import ru.kiz.developer.abdulaev.notesaschat.domain.Binder

class NoteViewBinder(
    private val noteViewPresenter: NoteViewPresenter
) : Binder.DataBinder.NoteBinder {
    override fun bind(body: String) {
        noteViewPresenter.setBody(body)
    }
}