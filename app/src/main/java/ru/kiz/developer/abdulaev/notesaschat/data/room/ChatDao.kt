package ru.kiz.developer.abdulaev.notesaschat.data.room

import androidx.room.*
import androidx.room.OnConflictStrategy.*
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.ChatRoomEntity

@Dao
interface ChatDao : Repository<ChatRoomEntity> {
    @Query("Select * FROM ChatRoomEntity where id = :id")
    override fun getById(id: Long): ChatRoomEntity?

    @Query("select * from ChatRoomEntity")
    override fun getAll(): List<ChatRoomEntity>

    @Insert(onConflict = REPLACE)
    override fun add(e: ChatRoomEntity): Long

    @Delete
    override fun remove(e: ChatRoomEntity)
}