package ru.kiz.developer.abdulaev.notesaschat.data.store

import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.room.entity.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.room.ChatDao

class ChatStore(
    dataStore: ChatDao
) : Repository.ChatRepo<ChatEntity>, DataStore<ChatEntity, ChatDao>(dataStore) {

}