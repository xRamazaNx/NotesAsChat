package ru.kiz.developer.abdulaev.notesaschat.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.kiz.developer.abdulaev.notesaschat.core.ID

@Entity
data class ChatEntity(
    val name: String
) : ID {
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0
}