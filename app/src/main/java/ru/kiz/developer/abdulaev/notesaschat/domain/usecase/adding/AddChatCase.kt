package ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding

import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteract

class AddChatCase(
    private val name: String,
    chatInteract: ChatInteract
) : Add<Chat, ChatInteract>(chatInteract) {
    override fun add(): Chat = interact.addChat(name)
}