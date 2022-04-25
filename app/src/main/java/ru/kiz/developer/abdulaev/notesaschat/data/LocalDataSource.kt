package ru.kiz.developer.abdulaev.notesaschat.data

import android.content.Context
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.room.impl.RoomDataSource

interface LocalDataSource {
    fun chatDataSource(): Repository.ChatRepo<ChatEntity>
    fun noteDataSource(): Repository.NoteRepo<NoteEntity>

    companion object {
        /** if need the another db to use that implement localDataSources and return here*/
        fun base(context: Context): LocalDataSource {
            return RoomDataSource("database.db", context)
        }

        /** if need to test the db return the localDataSource implementation here*/
        fun test(context: Context): LocalDataSource {
            return RoomDataSource("test_database.db", context)
        }
    }
}

