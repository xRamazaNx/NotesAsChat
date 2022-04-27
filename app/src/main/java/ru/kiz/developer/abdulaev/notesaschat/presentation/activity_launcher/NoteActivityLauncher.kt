package ru.kiz.developer.abdulaev.notesaschat.presentation.activity_launcher

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.presentation.activity.ChatActivity
import ru.kiz.developer.abdulaev.notesaschat.presentation.activity.NotesActivity

class NoteActivityLauncher(
    chatActivity: ChatActivity,
    override var callback: (Boolean) -> Unit
) : ResultLauncher<Boolean, Binder.DataBinder.ChatBinder>() {
    private val intent by lazy { Intent(chatActivity, NotesActivity::class.java) }
    override val resultLauncher = chatActivity.registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        callback.invoke(it.resultCode == Activity.RESULT_OK)
    }

    override fun launch(binder: Binder<Binder.DataBinder.ChatBinder>) {
        binder.bind(object : Binder.DataBinder.ChatBinder {
            override fun bind(id: Long, name: String, lastNoteStr: String) {
                intent.putExtra(ChatActivity.IEK_chatId, id)
                intent.putExtra(ChatActivity.IEK_chatName, name)
            }
        })
        resultLauncher.launch(intent)
    }
}