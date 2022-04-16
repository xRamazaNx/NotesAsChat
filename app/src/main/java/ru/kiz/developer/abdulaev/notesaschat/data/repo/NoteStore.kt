package ru.kiz.developer.abdulaev.notesaschat.data.repo

import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.data.repo.room.NoteDao

abstract class NoteStore(
    dataStore: NoteDao
) : DataStore<NoteEntity, NoteDao>(dataStore) {
    abstract fun lastNoteOfChat(id: Long): NoteEntity?
    abstract fun notesOfChat(chatId: Long): List<NoteEntity>

    class Base(
        private val dataStore: NoteDao
    ) : NoteStore(dataStore) {
        override fun lastNoteOfChat(id: Long): NoteEntity? {
            val allOfChat = dataStore.allOfChat(id)
            return allOfChat.lastOrNull()
        }

        override fun notesOfChat(chatId: Long): List<NoteEntity> {
            return dataStore.allOfChat(chatId)
        }
    }
}