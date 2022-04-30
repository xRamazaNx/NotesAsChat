package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.AbstractViewModel
import ru.kiz.developer.abdulaev.notesaschat.presentation.SelectionHandler.ChatSelectionHandler
import ru.kiz.developer.abdulaev.notesaschat.presentation.UiUpdater.ActivityUpdater.ChatActivityUpdater
import ru.kiz.developer.abdulaev.notesaschat.presentation.mapper.ChatToUiMapper

private val chatToUiMapper = ChatToUiMapper()

class ChatViewModel(
    private val chatInteractor: ChatInteractor,
    override val selectionHandler: ChatSelectionHandler<Chat>
) : AbstractViewModel<ChatUi, ChatActivityUpdater<ChatUi>>() {
    override val showAllLiveData = MutableLiveData<List<ChatUi>>()
    override var activityUpdater: ChatActivityUpdater<ChatUi>? = null

    fun addNewChat(
        name: String,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            val chat = chatInteractor.insert(name, chatToUiMapper)
            val updatedList = updatedDataList(chat)
            updateUI(updatedList)
            scrollToLast(updatedList)
        }
    }

    override fun showAll(dispatcher: CoroutineDispatcher) {
        viewModelScope.launch(dispatcher) {
            val chats = chatInteractor.all(chatToUiMapper)
            showAllLiveData.postValue(chats)
        }
    }

    override fun handleClick(item: ChatUi, isLongClick: Boolean, dispatcher: CoroutineDispatcher) {
        if (isLongClick || selectionHandler.isSelect()) {
            selectionHandler.handle(item)
            updateState()
        } else
            activityUpdater?.openChat(item)
    }

    override fun deleteItems(dispatcher: CoroutineDispatcher) {
        viewModelScope.launch(dispatcher) {
            chatInteractor.delete(selectionHandler.mapSelectedItems())
            selectionHandler.clear()
            showAll()
            updateState()
        }
    }
}