package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.core.Filler
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder.DataBinder

data class Chat(
    private val id: Long,
    private val name: String,
    private val lastNote: String = ""
) : Binder<DataBinder.ChatBinder>, ContentEqual, Filler<Filler.ValueFiller.ChatFiller> {
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

    override fun isEqualId(content: ContentEqual): Boolean {
        return content is Chat && id == content.id
    }

    override fun isEqualContent(content: ContentEqual): Boolean {
        return content is Chat &&
                name == content.name &&
                lastNote == content.lastNote
    }

    override fun fill(filler: Filler.ValueFiller.ChatFiller) {
        return filler.fill(id, name)
    }
}