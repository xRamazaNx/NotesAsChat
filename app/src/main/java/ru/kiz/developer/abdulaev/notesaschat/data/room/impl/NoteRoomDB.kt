package ru.kiz.developer.abdulaev.notesaschat.data.room.impl

import ru.kiz.developer.abdulaev.notesaschat.data.LocalDataSource
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.data.room.NoteDao
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.NoteRoomEntity

class NoteRoomDB(
    private val dao: NoteDao
) : LocalDataSource.NoteDB {

    override fun lastNoteOfChat(id: Long): NoteEntity? {
        val allOfChat = dao.allOfChat(id)
        return allOfChat.lastOrNull()
    }

    override fun notesOfChat(chatId: Long): List<NoteEntity> {
        return dao.allOfChat(chatId)
    }

    override fun create(chatId: Long, body: String): Long {
        return dao.add(NoteRoomEntity(chatId, body))
    }

    override fun getById(id: Long): NoteEntity? {
        return dao.getById(id)
    }

    override fun getAll(): List<NoteEntity> {
        return dao.getAll()
    }

    override fun add(e: NoteEntity): Long {
        return create(e.chatId, e.body)
    }

    override fun remove(e: NoteEntity) {
        dao.remove(NoteRoomEntity(e.chatId, e.body).also {
            it.id = e.id
        })
    }
}