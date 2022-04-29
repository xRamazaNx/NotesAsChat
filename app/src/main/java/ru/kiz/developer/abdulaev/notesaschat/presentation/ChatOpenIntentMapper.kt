package ru.kiz.developer.abdulaev.notesaschat.presentation

import android.content.Context
import android.content.Intent
import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatActivity
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NotesActivity

class ChatOpenIntentMapper(context: Context) : Mapper.DataMapper.ChatMapper<Intent> {
    val intent = Intent(context, NotesActivity::class.java)
    override fun map(id: Long, name: String, lastNote: String): Intent {
        return intent.apply {
            putExtra(ChatActivity.IEK_chatId, id)
            putExtra(ChatActivity.IEK_chatName, name)
        }
    }
}