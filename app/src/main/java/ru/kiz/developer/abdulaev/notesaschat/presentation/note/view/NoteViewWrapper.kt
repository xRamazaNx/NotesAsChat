package ru.kiz.developer.abdulaev.notesaschat.presentation.note.view

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.ViewWrapper

class NoteViewWrapper(
    noteViewBinding: NoteViewBinding
) : ViewWrapper(noteViewBinding.root), Mapper.DataMapper.NoteMapper<Unit> {
    private val note = noteViewBinding.note
    override fun map(id: Long, body: String) {
        note.text = body
    }
}