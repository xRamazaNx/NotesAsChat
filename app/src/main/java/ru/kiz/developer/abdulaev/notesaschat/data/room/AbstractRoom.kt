package ru.kiz.developer.abdulaev.notesaschat.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.ChatRoomEntity
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.NoteRoomEntity

@Database(
    entities = [
        ChatRoomEntity::class,
        NoteRoomEntity::class
    ],
    version = 1
)
abstract class AbstractRoom : RoomDatabase() {
    abstract fun chatDao(): ChatDao
    abstract fun noteDao(): NoteDao
}