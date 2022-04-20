package ru.kiz.developer.abdulaev.notesaschat.presentation.intent_filler

import android.content.Context
import android.content.Intent
import ru.kiz.developer.abdulaev.notesaschat.core.Filler

const val IEK_id = "id // Intent Extra Key"

class OpenChatIntentFiller(
    packageContext: Context, cls: Class<*>
) : Intent(packageContext, cls), Filler.ValueFiller.ChatFiller {
    override fun fill(id: Long) {
        putExtra(IEK_id, id)
    }
}