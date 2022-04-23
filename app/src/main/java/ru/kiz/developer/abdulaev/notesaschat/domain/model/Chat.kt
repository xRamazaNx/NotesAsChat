package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.core.Filler
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.core.Binder.DataToViewBinder

data class Chat(
    private val id: Long,
    private val name: String,
    private val lastNote: String = ""
) : Binder<DataToViewBinder.ChatViewBinder>, ContentEqual, Filler<Filler.ValueFiller.ChatFiller> {
    constructor(
        chatEntity: ChatEntity,
        lastNote: String = ""
    ) : this(
        chatEntity.id,
        chatEntity.name,
        lastNote
    )

    override fun bind(binder: DataToViewBinder.ChatViewBinder) {
        binder.bindView(name, lastNote)
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