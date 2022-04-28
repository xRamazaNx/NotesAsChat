package ru.kiz.developer.abdulaev.notesaschat.presentation.view.note

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.databinding.NoteViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.ViewWrapper

abstract class NoteViewWrapper(root: View) : ViewWrapper(root) {
    abstract fun setNote(body: String)
    class Base(
        noteViewBinding: NoteViewBinding
    ) : NoteViewWrapper(noteViewBinding.root) {
        private val note = noteViewBinding.note

        override fun setNote(body: String) {
            note.text = body
        }
    }
}