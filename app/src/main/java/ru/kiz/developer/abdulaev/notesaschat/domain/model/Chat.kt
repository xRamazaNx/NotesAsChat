package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity

data class Chat(
    val id: Long,
    val name: String,
    val lastNote: String = ""
) {
    constructor(
        chatEntity: ChatEntity,
        lastNote: String = ""
    ) : this(
        chatEntity.id,
        chatEntity.name,
        lastNote
    )
}