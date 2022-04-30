package ru.kiz.developer.abdulaev.notesaschat.data.room.impl

import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.room.ChatDao
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.ChatRoomEntity

class ChatRoomDataSource(
    private val dao: ChatDao
) : Repository.ChatRepo<ChatEntity> {

    override fun insert(e: ChatEntity): Long {
        return create(e.name)
    }

    override fun delete(e: ChatEntity) {
        dao.delete(ChatRoomEntity(e))
    }

    override fun create(name: String): Long {
        return dao.insert(ChatRoomEntity(name))
    }

    override fun getById(id: Long): ChatEntity? {
        return dao.getById(id)
    }

    override fun getAll(): List<ChatEntity> {
        return dao.getAll()
    }
}