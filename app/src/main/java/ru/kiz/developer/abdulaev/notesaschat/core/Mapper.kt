package ru.kiz.developer.abdulaev.notesaschat.core

interface MapContract {
    interface ChatMapContract {
        fun <T> map(mapper: Mapper.ChatMapper<T>): T
    }

    interface NoteMapContract {
        fun <T> map(mapper: Mapper.NoteMapper<T>): T
    }
}

interface Mapper {

    interface ChatMapper<T> : Mapper {
        fun map(id: Long, name: String, lastNote: String): T
    }

    interface NoteMapper<T> : Mapper {
        fun map(id: Long, body: String): T
    }
}