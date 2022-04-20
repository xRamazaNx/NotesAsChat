package ru.kiz.developer.abdulaev.notesaschat.presentation.presenter

import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityChatBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

interface ChatPresenter : Presenter.ActivityPresenter {

    class Base(
        private val binding: ActivityChatBinding
    ) : ChatPresenter {
        override fun smoothScrollTo(position: Int) {
            binding.recycler.smoothScrollToPosition(position)
        }

        override fun scrollTo(position: Int) {
            binding.recycler.scrollToPosition(position)
        }
    }
}