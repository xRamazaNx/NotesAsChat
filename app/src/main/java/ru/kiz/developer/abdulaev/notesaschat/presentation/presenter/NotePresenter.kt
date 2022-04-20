package ru.kiz.developer.abdulaev.notesaschat.presentation.presenter

import androidx.core.widget.addTextChangedListener
import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityNotesBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface NotePresenter : Presenter.ActivityPresenter {

    class Base(
        private val binding: ActivityNotesBinding
    ) : NotePresenter {

        init {
            binding.send.isEnabled = false
            binding.inputEditText.addTextChangedListener {
                binding.send.isEnabled = it?.toString()?.isNotBlank() == true
            }
        }

        override fun smoothScrollTo(position: Int) {
            binding.recycler.smoothScrollToPosition(position)
        }

        override fun scrollTo(position: Int) {
            binding.recycler.scrollToPosition(position)
        }
    }
}