package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.utils.inflate
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class NoteAdapter(
    clickListener: AbstractHolder.ClickListener<Note>
) : AbstractAdapter<Note, NoteHolder>(clickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteHolder {
        val noteView = parent.context.inflate(R.layout.note_view)
        return NoteHolder(noteView)
    }
}