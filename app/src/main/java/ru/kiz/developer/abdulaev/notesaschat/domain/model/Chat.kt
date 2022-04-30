package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity

data class Chat(
    private val id: Long,
    private val name: String,
    private val lastNote: String = ""
) {
    constructor(
        chatEntity: ChatEntity,
        lastNote: String = ""
    ) : this(
        chatEntity.id,
        chatEntity.name,
        lastNote
    )

    fun <T> map(mapper: Mapper.ChatMapper<T>): T {
        return mapper.map(id, name, lastNote)
    }
}