package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder

class NoteViewBinder(
    private val noteViewBinding: NoteViewBinding
) : Binder.DataBinder.NoteBinder {
    override fun bind(body: String) {
        noteViewBinding.note.text = body
    }
}