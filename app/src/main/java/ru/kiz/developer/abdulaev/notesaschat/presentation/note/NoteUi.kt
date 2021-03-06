package ru.kiz.developer.abdulaev.notesaschat.presentation.note

import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.core.MapObject
import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.UiModel

data class NoteUi(
    private val id: Long,
    private val body: String
) : UiModel(), MapObject.NoteMapObject {

    override fun <R> map(mapper: Mapper.NoteMapper<R>): R {
        return mapper.map(id, body)
    }

    override fun isEqualId(content: ContentEqual): Boolean {
        return content is NoteUi && id == content.id
    }

    override fun isEqualContent(content: ContentEqual): Boolean {
        return content is NoteUi && body == content.body
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NoteUi
        if (id != other.id) return false
        if (body != other.body) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + body.hashCode()
        return result
    }
}