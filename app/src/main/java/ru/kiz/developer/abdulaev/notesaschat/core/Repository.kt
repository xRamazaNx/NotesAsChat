package ru.kiz.developer.abdulaev.notesaschat.core

interface Repository<T> {
    fun getById(id: Long): T?
    fun getAll(): List<T>
    fun add(e: T): Long
    fun remove(e: T)

    interface ChatRepo<T> : Repository<T> {
        fun create(name: String): Long
    }

    interface NoteRepo<T> : Repository<T> {
        fun lastNoteOfChat(id: Long): T?
        fun notesOfChat(chatId: Long): List<T>
        fun create(chatId: Long, body: String): Long
    }
}