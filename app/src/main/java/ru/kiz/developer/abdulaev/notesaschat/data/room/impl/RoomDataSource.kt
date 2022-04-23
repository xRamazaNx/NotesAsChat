package ru.kiz.developer.abdulaev.notesaschat.data.room.impl

import android.content.Context
import androidx.room.Room
import ru.kiz.developer.abdulaev.notesaschat.data.LocalDataSource
import ru.kiz.developer.abdulaev.notesaschat.data.room.AbstractRoom

class RoomDataSource(
    databaseName: String,
    context: Context
) : LocalDataSource {
    private val chatRoomDB: ChatRoomDB
    private val noteRoomDB: NoteRoomDB

    init {
        val room = Room.databaseBuilder(
            context,
            AbstractRoom::class.java,
            databaseName
        ).build()

        chatRoomDB = ChatRoomDB(room.chatDao())
        noteRoomDB = NoteRoomDB(room.noteDao())
    }

    override fun chatDB(): LocalDataSource.ChatDB = chatRoomDB
    override fun noteDB(): LocalDataSource.NoteDB = noteRoomDB
}