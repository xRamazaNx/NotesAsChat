package ru.kiz.developer.abdulaev.notesaschat.domain.interact

import ru.kiz.developer.abdulaev.notesaschat.data.entity.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.repo.ChatStore
import ru.kiz.developer.abdulaev.notesaschat.data.repo.NoteStore
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat

interface ChatInteract : Interact {
    fun chat(id: Long): Chat?
    fun allChats(): List<Chat>
    fun addChat(name: String): Chat

    class Base(
        private val chatStore: ChatStore,
        private val noteStore: NoteStore
    ) : ChatInteract {
        override fun chat(id: Long): Chat? {
            return chatStore.getById(id)?.let { chatEntity ->
                mapToChat(chatEntity)
            }
        }

        override fun allChats(): List<Chat> {
            return chatStore.getAll().fold(mutableListOf()) { list, chatEntity ->
                list.add(mapToChat(chatEntity))
                list
            }
        }

        override fun addChat(name: String): Chat {
            return chatStore.add(ChatEntity(name)).let { chatEntityId ->
                chat(chatEntityId)!!
            }
        }

        private fun mapToChat(chatEntity: ChatEntity): Chat {
            return noteStore.lastNoteOfChat(chatEntity.id)?.let { noteEntity ->
                Chat(chatEntity, noteEntity.body)
            } ?: Chat(chatEntity)
        }
    }
}
