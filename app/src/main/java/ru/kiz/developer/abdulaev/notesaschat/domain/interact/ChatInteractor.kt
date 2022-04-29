package ru.kiz.developer.abdulaev.notesaschat.domain.interact

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper.DataMapper
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.data.ChatDomainToDataMapper
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat

interface ChatInteractor : Interactor {
    fun chat(id: Long): Chat?
    fun <T> allChats(chatToUiMapper: DataMapper.ChatMapper<T>): List<T>
    fun <T> addChat(name: String, chatToUiMapper: DataMapper.ChatMapper<T>): T
    fun remove(chat: Chat)

    class Base(
        private val chatRepo: Repository.ChatRepo<ChatEntity>,
        private val noteRepo: Repository.NoteRepo<NoteEntity>
    ) : ChatInteractor {
        override fun chat(id: Long): Chat? {
            return chatRepo.getById(id)?.let { chatEntity ->
                mapToChat(chatEntity)
            }
        }

        override fun <T> allChats(chatToUiMapper: DataMapper.ChatMapper<T>): List<T> {
            return chatRepo.getAll().fold(mutableListOf()) { list, chatEntity ->
                list.add(mapToChat(chatEntity).map(chatToUiMapper))
                list
            }
        }

        override fun <T> addChat(name: String, chatToUiMapper: DataMapper.ChatMapper<T>): T {
            return chatRepo.create(name).let { chatEntityId ->
                chat(chatEntityId)!!.map(chatToUiMapper)
            }
        }

        override fun remove(chat: Chat) {
            chatRepo.remove(chat.map(ChatDomainToDataMapper()))
        }

        private fun mapToChat(chatEntity: ChatEntity): Chat {
            return noteRepo.lastNoteOfChat(chatEntity.id)?.let { noteEntity ->
                Chat(chatEntity, noteEntity.body)
            } ?: Chat(chatEntity)
        }
    }
}
