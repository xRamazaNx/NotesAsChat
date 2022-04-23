package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.core.Binder.DataBinder

data class Note(
    private val id: Long,
    private val body: String
) : Binder<DataBinder.NoteBinder>, ContentEqual {
    constructor(
        noteEntity: NoteEntity
    ) : this(noteEntity.id, noteEntity.body)

    override fun bind(binder: DataBinder.NoteBinder) {
        binder.bind(id, body)
    }

    override fun isEqualId(content: ContentEqual): Boolean {
        return content is Note && id == content.id
    }

    override fun isEqualContent(content: ContentEqual): Boolean {
        return content is Note && body == content.body
    }
}