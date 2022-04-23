package ru.kiz.developer.abdulaev.notesaschat.data

import android.content.Context
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.room.impl.RoomDataSource

interface LocalDataSource {
    fun chatDataSource(): Repository.ChatRepo<ChatEntity>
    fun noteDataSource(): Repository.NoteRepo<NoteEntity>

    companion object {
        fun baseRoom(context: Context): LocalDataSource {
            return RoomDataSource("database.db", context)
        }

        fun testRoom(context: Context): LocalDataSource {
            return RoomDataSource("test_database.db", context)
        }
    }
}

