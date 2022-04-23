package ru.kiz.developer.abdulaev.notesaschat.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.NoteEntity

@Dao
interface NoteDao : Repository<NoteEntity> {
    @Query("Select * FROM NoteEntity where id = :id")
    override fun getById(id: Long): NoteEntity

    @Query("select * from NoteEntity")
    override fun getAll(): List<NoteEntity>

    @Insert(onConflict = REPLACE)
    override fun add(e: NoteEntity): Long

    @Delete
    override fun remove(e: NoteEntity)

    @Query("Select * FROM NoteEntity where chatId = :id")
    fun allOfChat(id: Long): List<NoteEntity>
}