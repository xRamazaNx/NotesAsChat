package ru.kiz.developer.abdulaev.notesaschat.data.room.impl

import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.data.room.NoteDao
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.NoteRoomEntity

class NoteRoomDataSource(
    private val dao: NoteDao
) : Repository.NoteRepo<NoteEntity> {

    override fun lastNoteOfChat(id: Long): NoteEntity? {
        val allOfChat = dao.allOfChat(id)
        return allOfChat.lastOrNull()
    }

    override fun notesOfChat(chatId: Long): List<NoteEntity> {
        return dao.allOfChat(chatId)
    }

    override fun create(chatId: Long, body: String): Long {
        return dao.insert(NoteRoomEntity(body, chatId))
    }

    override fun getById(id: Long): NoteEntity? {
        return dao.getById(id)
    }

    override fun getAll(): List<NoteEntity> {
        return dao.getAll()
    }

    override fun insert(e: NoteEntity): Long {
        return create(e.chatId, e.body)
    }

    override fun delete(e: NoteEntity) {
        dao.delete(NoteRoomEntity(e))
    }
}