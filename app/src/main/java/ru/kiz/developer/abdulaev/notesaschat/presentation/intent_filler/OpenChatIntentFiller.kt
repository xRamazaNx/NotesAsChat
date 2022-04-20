package ru.kiz.developer.abdulaev.notesaschat.presentation.intent_filler

import android.content.Intent
import ru.kiz.developer.abdulaev.notesaschat.core.Filler

const val IEK_chatId = "chatId" // Intent Extra Key

class OpenChatIntentFiller(
    private val intent: Intent
) : Filler.ValueFiller.ChatFiller {
    override fun fill(id: Long) {
        intent.putExtra(IEK_chatId, id)
    }
}