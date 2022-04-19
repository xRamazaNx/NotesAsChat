package ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import ru.kiz.developer.abdulaev.notesaschat.R
import ru.kiz.developer.abdulaev.notesaschat.databinding.ChatViewBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

class ChatAdapter(
    clickListener: AbstractHolder.ClickListener<Chat>
) : AbstractAdapter<Chat, ChatViewBinding, ChatHolder>(clickListener, DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatHolder {
        val inflater = LayoutInflater.from(parent.context)
        val chatView = inflater.inflate(R.layout.chat_view, parent, false)
        return ChatHolder(chatView)
    }

}

private class DiffCallback : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem.isEqualContent(newItem)
    }
}