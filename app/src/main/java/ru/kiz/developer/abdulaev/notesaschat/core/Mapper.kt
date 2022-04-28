package ru.kiz.developer.abdulaev.notesaschat.core

interface Mapper {
    interface DataMapper : Mapper {
        interface ChatMapper<T> : DataMapper {
            fun map(id: Long, name: String, lastNote: String): T
        }

        interface NoteMapper<T> : DataMapper {
            fun map(id: Long, body: String): T
        }
    }
}