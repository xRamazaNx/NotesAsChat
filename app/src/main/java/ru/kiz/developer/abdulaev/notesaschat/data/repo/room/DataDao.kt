package ru.kiz.developer.abdulaev.notesaschat.data.repo.room

interface DataDao<E> {
    fun getById(id: Long): E?
    fun getAll(): List<E>
    fun add(e: E): Long
    fun remove(e: E)
}