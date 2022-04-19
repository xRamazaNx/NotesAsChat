package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class NoteHolder(
    view: View
) : AbstractHolder<Note>(view), NotePresenter {
    private val binding = NoteViewBinding.bind(view)

    override fun bind(t: Note, clickListener: ClickListener<Note>) {
        super.bind(t, clickListener)
        t.bind(NoteViewBinder(this))
    }

    override fun setBody(body: String) {
        binding.note.text = body
    }
}