package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.ID
import ru.kiz.developer.abdulaev.notesaschat.data.entity.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder.DataBinder

data class Chat(
    override val id: Long,
    private val name: String,
    private val lastNote: String = ""
) : ID, Binder<DataBinder.ChatBinder>, ContentEqual {
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

    override fun isEqualContent(content: ContentEqual): Boolean {
        if (content !is Chat)
            return false
        return name == content.name && lastNote == content.lastNote
    }
}