package ru.kiz.developer.abdulaev.notesaschat.presentation.mapper

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteUi

class NoteToUiMapper : Mapper.NoteMapper<NoteUi> {
    override fun map(id: Long, body: String): NoteUi {
        return NoteUi(id, body)
    }
}