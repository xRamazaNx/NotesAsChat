package ru.kiz.developer.abdulaev.notesaschat.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatEntity(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}