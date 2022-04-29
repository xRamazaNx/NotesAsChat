package ru.kiz.developer.abdulaev.notesaschat.presentation.chat.view

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.ViewWrapper

class ChatViewWrapper(
    chatViewBinding: ChatViewBinding
) : ViewWrapper(chatViewBinding.infoContainer), Mapper.DataMapper.ChatMapper<Unit> {
    private val checkIcon = chatViewBinding.checkIcon
    private val name = chatViewBinding.chatName
    private val lastNote = chatViewBinding.lastNote
    override fun map(id: Long, name: String, lastNote: String) {
        this.name.text = name
        this.lastNote.text = lastNote
    }

    override fun onSwitchState(state: Boolean) {
        super.onSwitchState(state)
        val scale = if (state) 1f else 0f
        checkIcon.animate()
            .scaleX(scale)
            .scaleY(scale)
            .start()
        checkIcon.animate()
            .alpha(scale)
            .start()
    }

    override fun onBindState(state: Boolean) {
        super.onBindState(state)
        val scale = if (state) 1f else 0f
        checkIcon.scaleX = scale
        checkIcon.scaleY = scale
        checkIcon.alpha = scale
    }
}