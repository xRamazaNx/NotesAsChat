package ru.kiz.developer.abdulaev.notesaschat.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity

@Entity
data class ChatRoomEntity(
    override val name: String
) : ChatEntity() {
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0
}