package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.ID
import ru.kiz.developer.abdulaev.notesaschat.data.entity.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder
import ru.kiz.developer.abdulaev.notesaschat.domain.Binder.DataBinder

data class Note(
    override val id: Long,
    private val body: String
) : ID, Binder<DataBinder.NoteBinder>, ContentEqual {
    constructor(
        noteEntity: NoteEntity
    ) : this(noteEntity.id, noteEntity.body)

    override fun bind(binder: DataBinder.NoteBinder) {
        binder.bind(body)
    }

    override fun isEqualContent(content: ContentEqual): Boolean {
        if (content !is Note)
            return false
        return body == content.body
    }
}