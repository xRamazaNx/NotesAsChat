package ru.kiz.developer.abdulaev.notesaschat.data

abstract class NoteEntity {
    abstract var id: Long
    abstract val chatId: Long
    abstract val body: String
}