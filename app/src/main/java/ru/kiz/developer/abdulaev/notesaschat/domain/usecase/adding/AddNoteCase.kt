package ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding

import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor

class AddNoteCase(
    private val body: String,
    repository: NoteInteractor
) : Add<Note, NoteInteractor>(repository) {
    override fun add(): Note = interact.addNote(body)
}