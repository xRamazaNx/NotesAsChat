package ru.kiz.developer.abdulaev.notesaschat.presentation

import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual

class ChatUi(
    private val id: Long,
    private val name: String,
    private val lastNote: String
) : SelectionState(), Binder<Binder.DataBinder.ChatBinder> {

    override fun bind(binder: Binder.DataBinder.ChatBinder) {
        binder.bind(id, name, lastNote)
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