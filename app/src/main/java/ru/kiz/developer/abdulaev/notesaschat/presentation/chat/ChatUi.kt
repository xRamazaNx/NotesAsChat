package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.core.MapContract
import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.SelectionState

class ChatUi(
    private val id: Long,
    private val name: String,
    private val lastNote: String
) : SelectionState(), Mapper, ContentEqual, MapContract.ChatMapContract {

    override fun <R> map(mapper: Mapper.ChatMapper<R>): R {
        return mapper.map(id, name, lastNote)
    }

    override fun isEqualId(content: ContentEqual): Boolean {
        return content is ChatUi && id == content.id
    }

    override fun isEqualContent(content: ContentEqual): Boolean {
        return content is ChatUi &&
                name == content.name &&
                lastNote == content.lastNote
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ChatUi
        if (id != other.id) return false
        if (name != other.name) return false
        if (lastNote != other.lastNote) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + lastNote.hashCode()
        return result
    }
}