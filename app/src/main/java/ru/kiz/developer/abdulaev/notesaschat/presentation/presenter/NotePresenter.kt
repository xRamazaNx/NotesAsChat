package ru.kiz.developer.abdulaev.notesaschat.presentation.presenter

import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityNotesBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface NotePresenter : Presenter.ActivityPresenter {
    fun noteBody(): String
    fun clearBody()

    class Base(
        private val binding: ActivityNotesBinding
    ) : NotePresenter {
        override fun smoothScrollTo(position: Int) {
            binding.recycler.smoothScrollToPosition(position)
        }

        override fun noteBody(): String {
            return binding.inputEditText.text.toString()
        }

        override fun clearBody() {
            binding.inputEditText.setText("")
        }

        override fun scrollTo(position: Int) {
            binding.recycler.scrollToPosition(position)
        }
    }
}