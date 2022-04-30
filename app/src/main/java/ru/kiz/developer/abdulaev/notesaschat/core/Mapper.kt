package ru.kiz.developer.abdulaev.notesaschat.core

interface Mapper {
    interface ChatMapper<T> : Mapper {
        fun map(id: Long, name: String, lastNote: String): T
    }

    interface NoteMapper<T> : Mapper {
        fun map(id: Long, body: String): T
    }
}