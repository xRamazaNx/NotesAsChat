package ru.kiz.developer.abdulaev.notesaschat.data.room.entity

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
    override val chatId: Long,
    override val body: String
) : NoteEntity() {
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0L
}