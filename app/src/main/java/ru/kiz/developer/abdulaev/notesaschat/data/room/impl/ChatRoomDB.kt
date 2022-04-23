package ru.kiz.developer.abdulaev.notesaschat.data.room.impl

import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.LocalDataSource
import ru.kiz.developer.abdulaev.notesaschat.data.room.ChatDao
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.ChatRoomEntity

class ChatRoomDB(
    private val dao: ChatDao
) : LocalDataSource.ChatDB {

    override fun add(e: ChatEntity): Long {
        return create(e.name)
    }

    override fun remove(e: ChatEntity) {
        dao.remove(ChatRoomEntity(e.name).also {
            it.id = e.id
        })
    }

    override fun create(name: String): Long {
        return dao.add(ChatRoomEntity(name))
    }

    override fun getById(id: Long): ChatEntity? {
        return dao.getById(id)
    }

    override fun getAll(): List<ChatEntity> {
        return dao.getAll()
    }
}