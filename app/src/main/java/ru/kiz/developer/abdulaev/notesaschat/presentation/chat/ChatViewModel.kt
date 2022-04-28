package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.presentation.UiUpdater
import ru.kiz.developer.abdulaev.notesaschat.presentation.AbstractViewModel

class ChatViewModel(
    private val chatInteractor: ChatInteractor
) : AbstractViewModel<ChatUi, UiUpdater.ActivityUpdater>() {
    override val showAllLiveData = MutableLiveData<List<ChatUi>>()
    override var uiAction: UiUpdater.ActivityUpdater? = null
    private val chatToUiMapper = ChatToUiMapper()

    fun addNewChat(
        name: String,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            val chat = chatInteractor.addChat(name, chatToUiMapper)
            val updatedList = updatedDataList(chat)
            updateUI(updatedList)
            scrollToLast(updatedList)
        }
    }

    override fun showAll(dispatcher: CoroutineDispatcher) {
        viewModelScope.launch(dispatcher) {
            val chats = chatInteractor.allChats(chatToUiMapper)
            showAllLiveData.postValue(chats)
        }
    }
}
