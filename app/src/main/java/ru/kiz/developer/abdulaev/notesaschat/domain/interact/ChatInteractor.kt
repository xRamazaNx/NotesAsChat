package ru.kiz.developer.abdulaev.notesaschat.domain.interact

import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat

interface ChatInteractor : Interactor {
    fun chat(id: Long): Chat?
    fun allChats(): List<Chat>
    fun addChat(name: String): Chat

    class Base(
        private val chatRepo: Repository.ChatRepo<ChatEntity>,
        private val noteRepo: Repository.NoteRepo<NoteEntity>
    ) : ChatInteractor {
        override fun chat(id: Long): Chat? {
            return chatRepo.getById(id)?.let { chatEntity ->
                mapToChat(chatEntity)
            }
        }

        override fun allChats(): List<Chat> {
            return chatRepo.getAll().fold(mutableListOf()) { list, chatEntity ->
                list.add(mapToChat(chatEntity))
                list
            }
        }

        override fun addChat(name: String): Chat {
            return chatRepo.create(name).let { chatEntityId ->
                chat(chatEntityId)!!
            }
        }

        private fun mapToChat(chatEntity: ChatEntity): Chat {
            return noteRepo.lastNoteOfChat(chatEntity.id)?.let { noteEntity ->
                Chat(chatEntity, noteEntity.body)
            } ?: Chat(chatEntity)
        }
    }
}
