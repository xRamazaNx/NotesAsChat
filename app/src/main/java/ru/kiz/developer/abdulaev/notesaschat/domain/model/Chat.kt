package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.core.Binder.DataBinder
import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity

data class Chat(
    private val id: Long,
    private val name: String,
    private val lastNote: String = ""
) : Binder<DataBinder.ChatBinder>, ContentEqual {
    constructor(
        chatEntity: ChatEntity,
        lastNote: String = ""
    ) : this(
        chatEntity.id,
        chatEntity.name,
        lastNote
    )

    override fun bind(binder: DataBinder.ChatBinder) {
        binder.bind(id, name, lastNote)
    }

    override fun isEqualId(content: ContentEqual): Boolean {
        return content is Chat && id == content.id
    }

    override fun isEqualContent(content: ContentEqual): Boolean {
        return content is Chat &&
                name == content.name &&
                lastNote == content.lastNote
    }
}