package ru.kiz.developer.abdulaev.notesaschat.presentation.note.view

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class NoteHolder(
    view: View
) : AbstractHolder<NoteUi, NoteViewWrapper>(view) {
    override val viewWrapper = NoteViewWrapper(NoteViewBinding.bind(view))

    override fun bindHolder(t: NoteUi, clickListener: ClickListener<NoteUi>) {
        super.bindHolder(t, clickListener)
        t.map(viewWrapper)
    }
}