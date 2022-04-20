package ru.kiz.developer.abdulaev.notesaschat.presentation

interface Presenter {

    interface ViewPresenter

    interface ActivityPresenter {
        fun smoothScrollTo(@androidx.annotation.IntRange(from = 0) position: Int)
        fun scrollTo(position: Int)
    }
}