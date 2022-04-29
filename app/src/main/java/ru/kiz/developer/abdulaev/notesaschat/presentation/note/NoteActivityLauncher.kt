package ru.kiz.developer.abdulaev.notesaschat.presentation.note

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import ru.kiz.developer.abdulaev.notesaschat.presentation.ResultLauncher
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatActivity

class NoteActivityLauncher(
    chatActivity: ChatActivity,
    override var callback: (Boolean) -> Unit
) : ResultLauncher<Boolean>() {
    override val resultLauncher = chatActivity.registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        callback.invoke(it.resultCode == Activity.RESULT_OK)
    }

    override fun launch(intent: Intent) {
        resultLauncher.launch(intent)
    }
}