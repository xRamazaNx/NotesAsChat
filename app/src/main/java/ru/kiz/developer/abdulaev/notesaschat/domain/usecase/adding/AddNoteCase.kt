package ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding

import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteract

class AddNoteCase(
    private val body: String,
    repository: NoteInteract
) : Add<Note, NoteInteract>(repository) {
    override fun add(): Note = interact.addNote(body)
}