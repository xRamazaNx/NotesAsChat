package ru.kiz.developer.abdulaev.notesaschat.data.store

import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.data.room.NoteDao

class NoteStore(
    private val dataStore: NoteDao
) : Repository.NoteRepo<NoteEntity>, DataStore<NoteEntity, NoteDao>(dataStore) {

    override fun lastNoteOfChat(id: Long): NoteEntity? {
        val allOfChat = dataStore.allOfChat(id)
        return allOfChat.lastOrNull()
    }

    override fun notesOfChat(chatId: Long): List<NoteEntity> {
        return dataStore.allOfChat(chatId)
    }
}