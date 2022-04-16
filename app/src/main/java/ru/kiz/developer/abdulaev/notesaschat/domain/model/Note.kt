package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder.DataBinder

data class Note(
    val id: Long,
    private val body: String
) : Binder<DataBinder.NoteBinder>, ContentEqual<Note> {
    constructor(
        noteEntity: NoteEntity
    ) : this(noteEntity.id, noteEntity.body)

    override fun bind(binder: DataBinder.NoteBinder) {
        binder.bind(body)
    }

    override fun isEqualContent(content: Note): Boolean {
        return body == content.body
    }
}