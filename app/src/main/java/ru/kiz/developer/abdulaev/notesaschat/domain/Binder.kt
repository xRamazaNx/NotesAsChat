package ru.kiz.developer.abdulaev.notesaschat.domain

interface Binder<B : Binder.DataBinder> {
    fun bind(binder: B)

    interface DataBinder {
        interface ChatBinder : DataBinder {
            fun bind(name: String, lastNoteStr: String)
        }

        interface NoteBinder : DataBinder {
            fun bind(body: String)
        }
    }
}