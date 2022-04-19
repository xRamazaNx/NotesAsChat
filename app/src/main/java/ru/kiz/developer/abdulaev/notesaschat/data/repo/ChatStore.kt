package ru.kiz.developer.abdulaev.notesaschat.data.repo

import ru.kiz.developer.abdulaev.notesaschat.data.entity.ChatEntity
import ru.kiz.developer.abdulaev.notesaschat.data.repo.room.ChatDao

abstract class ChatStore(
    dataStore: ChatDao
) : DataStore<ChatEntity, ChatDao>(dataStore) {
    class Base(
        dataStore: ChatDao
    ) : ChatStore(dataStore)
}