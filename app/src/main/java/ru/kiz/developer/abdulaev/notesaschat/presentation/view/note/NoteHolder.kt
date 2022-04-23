package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class NoteHolder(
    view: View
) : AbstractHolder<Note>(view), Binder.DataBinder.NoteBinder {
    private val binding = NoteViewBinding.bind(view)

    override fun bindHolder(t: Note, clickListener: ClickListener<Note>) {
        super.bindHolder(t, clickListener)
        t.bind(this)
    }

    override fun bind(id: Long, body: String) {
        binding.note.text = body
    }
}