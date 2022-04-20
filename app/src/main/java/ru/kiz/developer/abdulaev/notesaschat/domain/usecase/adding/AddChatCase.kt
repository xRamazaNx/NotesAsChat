package ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding

import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor

class AddChatCase(
    private val name: String,
    chatInteractor: ChatInteractor
) : Add<Chat, ChatInteractor>(chatInteractor) {
    override fun add(): Chat = interact.addChat(name)
}