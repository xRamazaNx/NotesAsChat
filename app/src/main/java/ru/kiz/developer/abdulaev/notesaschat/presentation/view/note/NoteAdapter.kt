package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.utils.DiffUtilCallback
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class NoteAdapter(
    clickListener: AbstractHolder.ClickListener<Note>
) : AbstractAdapter<Note, NoteViewBinding, NoteHolder>(clickListener, DiffUtilCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.note_view, parent, false)
        return NoteHolder(view)
    }

}