package ru.kiz.developer.abdulaev.notesaschat.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}