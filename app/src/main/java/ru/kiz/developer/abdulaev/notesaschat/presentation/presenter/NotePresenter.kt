package ru.kiz.developer.abdulaev.notesaschat.presentation.presenter

import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityNotesBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface NotePresenter : Presenter {
    fun smoothScrollTo(@androidx.annotation.IntRange(from = 0) position: Int)
    fun noteBody(): String
    fun clearBody()
    fun scrollTo(position: Int)

    class Base(
        private val activityNotesBinding: ActivityNotesBinding
    ) : NotePresenter {
        override fun smoothScrollTo(position: Int) {
            activityNotesBinding.recycler.smoothScrollToPosition(position)
        }

        override fun noteBody(): String {
            return activityNotesBinding.inputEditText.text.toString()
        }

        override fun clearBody() {
            activityNotesBinding.inputEditText.setText("")
        }

        override fun scrollTo(position: Int) {
            activityNotesBinding.recycler.scrollToPosition(position)
        }
    }
}