package ru.kiz.developer.abdulaev.notesaschat.domain.interact

import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat

interface CaseDeleteItems<I> {
    fun delete(items: List<I>)

    class CaseDeleteChats(
        private val repository: ChatInteractor
    ) : CaseDeleteItems<Chat> {
        override fun delete(items: List<Chat>) {
            items.forEach { chat ->
                repository.remove(chat)
            }
        }
    }
}