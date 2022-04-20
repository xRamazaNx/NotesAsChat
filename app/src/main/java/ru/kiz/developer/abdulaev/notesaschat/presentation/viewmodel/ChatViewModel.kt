package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding.AddChatCase
import ru.kiz.developer.abdulaev.notesaschat.presentation.presenter.ChatPresenter

abstract class ChatViewModel : ViewModelInterface<Chat, ChatPresenter>() {
    abstract fun addNewChat(name: String, dispatcher: CoroutineDispatcher = Dispatchers.IO)
    private class Base(
        private val chatInteractor: ChatInteractor
    ) : ChatViewModel() {
        override val showAllLiveData = MutableLiveData<List<Chat>>()
        override var presenter: ChatPresenter? = null

        override fun addNewChat(name: String, dispatcher: CoroutineDispatcher) {
            viewModelScope.launch(dispatcher) {
                val addChatCase = AddChatCase(name, chatInteractor)
                val chat = addChatCase.execute()
                val updatedList = updatedDataList(chat)
                updateUI(updatedList)
                scrollToLast(updatedList)
            }
        }

        override fun showAll(dispatcher: CoroutineDispatcher) {
            viewModelScope.launch(dispatcher) {
                val chats = chatInteractor.allChats()
                showAllLiveData.postValue(chats)
            }
        }
    }

    class ChatViewModelFactory(
        private val chatInteractor: ChatInteractor
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return Base(chatInteractor) as T
        }
    }
}
