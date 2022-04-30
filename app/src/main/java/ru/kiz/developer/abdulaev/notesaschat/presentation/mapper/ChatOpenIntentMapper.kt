package ru.kiz.developer.abdulaev.notesaschat.presentation.mapper

import android.content.Context
import android.content.Intent
import ru.kiz.developer.abdulaev.notesaschat.core.Mapper.ChatMapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatActivity

class ChatOpenIntentMapper(context: Context, clazz: Class<*>) : ChatMapper<Intent> {
    private val intent = Intent(context, clazz)
    override fun map(id: Long, name: String, lastNote: String): Intent {
        return intent.apply {
            putExtra(ChatActivity.IEK_chatId, id)
            putExtra(ChatActivity.IEK_chatName, name)
        }
    }
}