package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteract
import ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding.AddChatCase

abstract class ChatViewModel : ViewModel(), ViewModelInterface<Chat> {
    abstract fun addNewChat(name: String)
    private class Base(
        private val chatInteract: ChatInteract
    ) : ChatViewModel() {
        override val showAllLiveData = MutableLiveData<List<Chat>>()
        override fun addNewChat(name: String) {
            viewModelScope.launch(Dispatchers.IO) {
                val addChatCase = AddChatCase(name, chatInteract)
                val chat = addChatCase.execute()
                update(chat)
            }
        }

        override fun showAll() {
            viewModelScope.launch(Dispatchers.IO) {
                val chats = chatInteract.allChats()
                showAllLiveData.postValue(chats)
            }
        }
    }

    class ChatViewModelFactory(
        private val chatInteract: ChatInteract
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return Base(chatInteract) as T
        }
    }
}
