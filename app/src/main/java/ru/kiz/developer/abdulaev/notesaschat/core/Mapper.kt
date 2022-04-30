package ru.kiz.developer.abdulaev.notesaschat.core

interface MapObject {
    interface ChatMapObject {
        fun <T> map(mapper: Mapper.ChatMapper<T>): T
    }

    interface NoteMapObject {
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