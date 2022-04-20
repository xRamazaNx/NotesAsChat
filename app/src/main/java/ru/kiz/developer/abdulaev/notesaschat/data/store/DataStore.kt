package ru.kiz.developer.abdulaev.notesaschat.data.store

import ru.kiz.developer.abdulaev.notesaschat.core.Repository

abstract class DataStore<E, D : Repository<E>>(
    private val dao: D
) : Repository<E> {

    override fun getById(id: Long): E? {
        return dao.getById(id)
    }

    override fun getAll(): List<E> {
        return dao.getAll()
    }

    override fun add(e: E): Long {
        return dao.add(e)
    }

    override fun remove(e: E) {
        dao.remove(e)
    }
}