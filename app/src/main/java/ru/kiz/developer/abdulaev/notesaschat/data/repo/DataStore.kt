package ru.kiz.developer.abdulaev.notesaschat.data.repo

import ru.kiz.developer.abdulaev.notesaschat.data.repo.room.DataDao

abstract class DataStore<E, D : DataDao<E>>(
    private val dao: D
) : DataDao<E> {

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