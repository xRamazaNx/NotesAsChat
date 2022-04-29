package ru.kiz.developer.abdulaev.notesaschat.presentation

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper.DataMapper.ChatMapper
import ru.kiz.developer.abdulaev.notesaschat.core.Mapper.DataMapper.NoteMapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteUi

interface SelectionHandler<T> {
    fun handle(t: T)
    fun clear()
    fun isSelect(): Boolean

    abstract class AbstractSelectionHandler<T : ViewState<Boolean>> : SelectionHandler<T> {
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
            selectedItems.clear()
        }
    }

    class ChatSelectionHandler : AbstractSelectionHandler<ChatUi>() {
        fun <R> mapSelectedItems(mapper: ChatMapper<R>): List<R> {
            return selectedItems.fold(mutableListOf()) { list, chatUi ->
                list.add(chatUi.map(mapper))
                list
            }
        }
    }

    class NoteSelectionHandler : AbstractSelectionHandler<NoteUi>() {
        fun <R> mapSelectedItems(mapper: NoteMapper<R>): List<R> {
            return selectedItems.fold(mutableListOf()) { list, noteUi ->
                list.add(noteUi.map(mapper))
                list
            }
        }
    }
}