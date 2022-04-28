package ru.kiz.developer.abdulaev.notesaschat.presentation.chat.view

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.ViewWrapper

abstract class ChatViewWrapper(root: View) : ViewWrapper(root) {
    abstract fun setName(name: String)
    abstract fun setLastNote(note: String)

    class Base(
        chatViewBinding: ChatViewBinding
    ) : ChatViewWrapper(chatViewBinding.root) {
        private val chatName = chatViewBinding.chatName
        private val lastNote = chatViewBinding.lastNote

        override fun setName(name: String) {
            chatName.text = name
        }

        override fun setLastNote(note: String) {
            lastNote.text = note
        }
    }
}