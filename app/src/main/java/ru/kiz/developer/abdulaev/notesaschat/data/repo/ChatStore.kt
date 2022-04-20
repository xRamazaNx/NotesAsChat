package ru.kiz.developer.abdulaev.notesaschat.data.repo

import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.entity.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.repo.room.ChatDao

class ChatStore(
    dataStore: ChatDao
) : Repository.ChatRepo<ChatEntity>, DataStore<ChatEntity, ChatDao>(dataStore) {

}