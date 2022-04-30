package ru.kiz.developer.abdulaev.notesaschat.domain

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note

class NoteUiToDomainMapper : Mapper.NoteMapper<Note> {
    override fun map(id: Long, body: String): Note {
        return Note(id, body)
    }
}