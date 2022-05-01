package ru.kiz.developer.abdulaev.notesaschat.data.room.impl

import android.content.Context
import androidx.room.Room
import ru.kiz.developer.abdulaev.notesaschat.data.LocalDataSource
import ru.kiz.developer.abdulaev.notesaschat.data.room.RoomDataBase

class RoomDataSource(
    databaseName: String,
    context: Context
) : LocalDataSource {
    private val chatRoomDataSource: ChatRoomDataSource
    private val noteRoomDataSource: NoteRoomDataSource

    init {
        val room = Room.databaseBuilder(
            context,
            RoomDataBase::class.java,
            databaseName
        ).build()

        chatRoomDataSource = ChatRoomDataSource(room.chatDao())
        noteRoomDataSource = NoteRoomDataSource(room.noteDao())
    }

    override fun chatDataSource() = chatRoomDataSource
    override fun noteDataSource() = noteRoomDataSource
}