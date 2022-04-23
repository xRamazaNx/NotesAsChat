package ru.kiz.developer.abdulaev.notesaschat.presentation

interface UiUpdater {
    interface ActivityUpdater : UiUpdater {
        fun smoothScrollTo(position: Int)
        fun scrollTo(position: Int)
    }
}