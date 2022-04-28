package ru.kiz.developer.abdulaev.notesaschat.presentation.note.view

import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.utils.inflate

class NoteAdapter(
    clickListener: AbstractHolder.ClickListener<NoteUi>
) : AbstractAdapter<NoteUi, NoteHolder>(clickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteHolder {
        val noteView = parent.context.inflate(R.layout.note_view)
        return NoteHolder(noteView)
    }
}