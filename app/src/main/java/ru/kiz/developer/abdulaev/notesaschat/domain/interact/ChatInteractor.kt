package ru.kiz.developer.abdulaev.notesaschat.domain.interact

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.data.mapper.ChatDomainToDataMapper
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat

interface ChatInteractor : Interactor<Chat> {
    fun chat(id: Long): Chat?
    fun <T> insert(name: String, chatToUiMapper: Mapper.ChatMapper<T>): T
    fun <T> all(chatToUiMapper: Mapper.ChatMapper<T>): List<T>

    class Base(
        private val chatRepo: Repository.ChatRepo<ChatEntity>,
        private val noteRepo: Repository.NoteRepo<NoteEntity>
    ) : ChatInteractor {
        override fun chat(id: Long): Chat? {
            return chatRepo.getById(id)?.let { chatEntity ->
                mapToChat(chatEntity)
            }
        }

        override fun <T> all(chatToUiMapper: Mapper.ChatMapper<T>): List<T> {
            return chatRepo.getAll().fold(mutableListOf()) { list, chatEntity ->
                list.add(mapToChat(chatEntity).map(chatToUiMapper))
                list
            }
        }

        override fun <T> insert(name: String, chatToUiMapper: Mapper.ChatMapper<T>): T {
            return chatRepo.create(name).let { chatEntityId ->
                chat(chatEntityId)!!.map(chatToUiMapper)
            }
        }

        override fun delete(items: List<Chat>) {
            items.forEach { chat ->
                chatRepo.delete(chat.map(ChatDomainToDataMapper()))
            }
        }

        private fun mapToChat(chatEntity: ChatEntity): Chat {
            return noteRepo.lastNoteOfChat(chatEntity.id)?.let { noteEntity ->
                Chat(chatEntity, noteEntity.body)
            } ?: Chat(chatEntity)
        }
    }
}
