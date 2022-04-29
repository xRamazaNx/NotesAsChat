package ru.kiz.developer.abdulaev.notesaschat.presentation

import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteUi

interface SelectionHandler<T> {
    fun handle(t: T)
    fun giveSelectedItems(): List<T>
    fun clear()
    fun isSelect() = giveSelectedItems().isNotEmpty()

    abstract class AbstractSelectionHandler<T : ViewState<Boolean>> :
        SelectionHandler<T> {
        private val selectedItems = mutableSetOf<T>()
        override fun giveSelectedItems(): List<T> = selectedItems.toList()
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

    class ChatSelectionHandler : AbstractSelectionHandler<ChatUi>()
    class NoteSelectionHandler : AbstractSelectionHandler<NoteUi>()
}