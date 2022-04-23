package ru.kiz.developer.abdulaev.notesaschat.core

interface Binder<B : Binder.DataBinder> {
    fun bind(binder: B)

    interface DataBinder {
        interface ChatBinder : DataBinder {
            fun bind(id: Long, name: String, lastNoteStr: String)
        }

        interface NoteBinder : DataBinder {
            fun bind(id: Long, body: String)
        }
    }
}