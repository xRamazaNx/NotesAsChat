package ru.kiz.developer.abdulaev.notesaschat.presentation


interface UiUpdater {
    interface StateUpdater {
        fun defaultState()
        fun selectionState()
    }

    interface ActivityUpdater : UiUpdater, StateUpdater {
        fun smoothScrollTo(position: Int)
        fun scrollTo(position: Int)

        interface ChatActivityUpdater<T> : ActivityUpdater {
            fun openChat(t: T)
        }

        interface NoteActivityUpdater : ActivityUpdater {
        }
    }
}