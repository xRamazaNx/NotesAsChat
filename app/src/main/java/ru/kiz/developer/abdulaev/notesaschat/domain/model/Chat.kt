package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder.DataBinder

data class Chat(
    val id: Long,
    private val name: String,
    private val lastNote: String = ""
) : Binder<DataBinder.ChatBinder>, ContentEqual<Chat> {
    constructor(
        chatEntity: ChatEntity,
        lastNote: String = ""
    ) : this(
        chatEntity.id,
        chatEntity.name,
        lastNote
    )

    override fun bind(binder: DataBinder.ChatBinder) {
        binder.bind(name, lastNote)
    }

    override fun isEqualContent(content: Chat): Boolean {
        return name == content.name && lastNote == content.lastNote
    }
}