package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class NoteAdapter(
    clickListener: AbstractHolder.ClickListener<Note>
) : AbstractAdapter<Note, NoteViewBinding, NoteHolder>(clickListener) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteHolder {
        val inflater = LayoutInflater.from(parent.context)
        val chatViewBinding = NoteViewBinding.inflate(inflater)
        return NoteHolder(chatViewBinding)
    }
}