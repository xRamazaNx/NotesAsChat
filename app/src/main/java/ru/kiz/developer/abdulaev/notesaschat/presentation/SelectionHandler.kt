package ru.kiz.developer.abdulaev.notesaschat.presentation

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteUi

interface SelectionHandler<T> {
    fun handle(t: T)
    fun clear()
    fun isSelect(): Boolean

    abstract class AbstractSelectionHandler<T : ViewState<Boolean>, R> :
        SelectionHandler<T> {
        protected val selectedItems = mutableSetOf<T>()

        override fun isSelect() = selectedItems.isNotEmpty()

        override fun handle(t: T) {
            val newState = t.switchState()
            if (newState)
                selectedItems.add(t)
            else
                selectedItems.remove(t)
        }

        override fun clear() {
            selectedItems.forEach { it.switchState() }
            selectedItems.clear()
        }

        fun mapSelectedItems(): List<R> {
            return selectedItems.fold(mutableListOf()) { list, chatUi ->
                list.add(map(chatUi))
                list
            }
        }

        abstract fun map(t: T): R
    }

    abstract class ChatSelectionHandler<R> private constructor(
        private val selectionItemsMapper: Mapper.ChatMapper<R>
    ) : AbstractSelectionHandler<ChatUi, R>() {
        override fun map(t: ChatUi): R = t.map(selectionItemsMapper)

        class Base(mapper: Mapper.ChatMapper<Chat>) : ChatSelectionHandler<Chat>(mapper)
    }

    abstract class NoteSelectionHandler<R> private constructor(
        private val selectionItemsMapper: Mapper.NoteMapper<R>
    ) : AbstractSelectionHandler<NoteUi, R>() {
        override fun map(t: NoteUi): R = t.map(selectionItemsMapper)

        class Base(mapper: Mapper.NoteMapper<Note>) : NoteSelectionHandler<Note>(mapper)
    }
}