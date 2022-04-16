package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class NoteHolder(
    binding: NoteViewBinding
) : AbstractHolder<Note, NoteViewBinding>(binding) {
    override fun bind(t: Note, clickListener: ClickListener<Note>) {
        super.bind(t, clickListener)
        t.bind(NoteViewBinder(binding))
    }
}