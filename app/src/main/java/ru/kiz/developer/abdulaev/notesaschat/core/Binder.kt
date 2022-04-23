package ru.kiz.developer.abdulaev.notesaschat.core

interface Binder<B : Binder.DataToViewBinder> {
    fun bind(binder: B)

    interface DataToViewBinder {
        interface ChatViewBinder : DataToViewBinder {
            fun bindView(name: String, lastNoteStr: String)
        }

        interface NoteViewBinder : DataToViewBinder {
            fun bindView(body: String)
        }
    }
}