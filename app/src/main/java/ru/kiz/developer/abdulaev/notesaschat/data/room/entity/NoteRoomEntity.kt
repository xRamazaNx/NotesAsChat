package ru.kiz.developer.abdulaev.notesaschat.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ChatRoomEntity::class,
            parentColumns = ["id"],
            childColumns = ["chatId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class NoteRoomEntity(
    override val body: String,
    @ColumnInfo(index = true)
    override val chatId: Long,
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0L
) : NoteEntity {
    constructor(e: NoteEntity) : this(e.body, e.chatId, e.id)
}