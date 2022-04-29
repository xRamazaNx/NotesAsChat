package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.ChatUiToDomainMapper
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.CaseDeleteItems
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.presentation.UiUpdater
import ru.kiz.developer.abdulaev.notesaschat.presentation.AbstractViewModel
import ru.kiz.developer.abdulaev.notesaschat.presentation.SelectionHandler

private val chatToUiMapper = ChatToUiMapper()

class ChatViewModel(
    private val chatInteractor: ChatInteractor,
) : AbstractViewModel<ChatUi, UiUpdater.ActivityUpdater>() {
    override val selectionHandler = SelectionHandler.ChatSelectionHandler()
    override val showAllLiveData = MutableLiveData<List<ChatUi>>()
    override var activityUpdater: UiUpdater.ActivityUpdater? = null

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

    override fun handleClick(item: ChatUi, dispatcher: CoroutineDispatcher) {
        selectionHandler.handle(item) {
            // TODO: change the state using livedata
        }
    }

    override fun deleteItems(dispatcher: CoroutineDispatcher) {
        viewModelScope.launch(dispatcher) {
            CaseDeleteItems
                .CaseDeleteChats(chatInteractor)
                .delete(
                    selectionHandler.giveSelectedItems()
                        .fold(mutableListOf()) { list, ui ->
                            list.add(ui.map(ChatUiToDomainMapper()))
                            list
                        }
                )
            selectionHandler.clear()
            showAll()
        }
    }
}
