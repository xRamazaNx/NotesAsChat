package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity

data class Note(
    val id: Long,
    val body: String
) {
    constructor(noteEntity: NoteEntity) : this(noteEntity.id, noteEntity.body)
}