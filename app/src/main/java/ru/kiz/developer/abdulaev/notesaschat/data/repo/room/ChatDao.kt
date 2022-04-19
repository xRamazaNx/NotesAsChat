package ru.kiz.developer.abdulaev.notesaschat.data.repo.room

import androidx.room.*
import androidx.room.OnConflictStrategy.*
import ru.kiz.developer.abdulaev.notesaschat.data.entity.ChatEntity

@Dao
interface ChatDao : DataDao<ChatEntity> {
    @Query("Select * FROM ChatEntity where id = :id")
    override fun getById(id: Long): ChatEntity?

    @Query("select * from ChatEntity")
    override fun getAll(): List<ChatEntity>

    @Insert(onConflict = REPLACE)
    override fun add(e: ChatEntity): Long

    @Delete
    override fun remove(e: ChatEntity)
}