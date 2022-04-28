package ru.kiz.developer.abdulaev.notesaschat.presentation.note

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper

class NoteToUiMapper : Mapper.DataMapper.NoteMapper<NoteUi> {
    override fun map(id: Long, body: String): NoteUi {
        return NoteUi(id, body)
    }
}