package ru.kiz.developer.abdulaev.notesaschat.data.repo.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity

@Database(
    entities = [
        ChatEntity::class,
        NoteEntity::class
    ],
    version = 1
)
abstract class Room : RoomDatabase() {
    companion object {
        private var room: Room? = null
        @Synchronized
        fun get(context: Context): Room {
            if (room == null)
                room = androidx.room.Room.databaseBuilder(
                    context,
                    Room::class.java, "database.db"
                ).build()
            return room!!
        }
    }

    abstract fun chatDao(): ChatDao
    abstract fun noteDao(): NoteDao
}