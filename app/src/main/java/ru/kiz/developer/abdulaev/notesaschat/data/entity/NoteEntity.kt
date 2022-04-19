package ru.kiz.developer.abdulaev.notesaschat.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.kiz.developer.abdulaev.notesaschat.core.ID

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ChatEntity::class,
            parentColumns = ["id"],
            childColumns = ["chatId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class NoteEntity(
    val chatId: Long,
    val body: String
) : ID {
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0L
}