package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity

data class Note(
    private val id: Long,
    private val body: String
) {
    constructor(
        noteEntity: NoteEntity
    ) : this(noteEntity.id, noteEntity.body)

    fun <T> map(mapper: Mapper.NoteMapper<T>): T {
        return mapper.map(id, body)
    }
}