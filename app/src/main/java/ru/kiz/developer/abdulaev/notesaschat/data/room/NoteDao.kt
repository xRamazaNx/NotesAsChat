package ru.kiz.developer.abdulaev.notesaschat.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.NoteRoomEntity

@Dao
interface NoteDao : Repository<NoteRoomEntity> {
    @Query("Select * FROM NoteRoomEntity where id = :id")
    override fun getById(id: Long): NoteRoomEntity?

    @Query("select * from NoteRoomEntity")
    override fun getAll(): List<NoteRoomEntity>

    @Insert(onConflict = REPLACE)
    override fun add(e: NoteRoomEntity): Long

    @Delete
    override fun remove(e: NoteRoomEntity)

    @Query("Select * FROM NoteRoomEntity where chatId = :id")
    fun allOfChat(id: Long): List<NoteRoomEntity>
}