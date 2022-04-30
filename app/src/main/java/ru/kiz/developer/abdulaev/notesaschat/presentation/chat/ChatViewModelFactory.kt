package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kiz.developer.abdulaev.notesaschat.domain.ChatUiToDomainMapper
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.presentation.SelectionHandler.ChatSelectionHandler

@Suppress("UNCHECKED_CAST")
class ChatViewModelFactory(
    private val chatInteractor: ChatInteractor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val chatUiToDomainMapper = ChatUiToDomainMapper()
        return ChatViewModel(
            chatInteractor,
            ChatSelectionHandler.Base(chatUiToDomainMapper)
        ) as T
    }
}