package ru.kiz.developer.abdulaev.notesaschat.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatUi

abstract class AbstractViewModel<T, U : UiUpdater.ActivityUpdater> : ViewModel() {
    abstract val showAllLiveData: MutableLiveData<List<T>>
    protected abstract var activityUpdater: U?
    protected abstract val selectionHandler: SelectionHandler<T>
    abstract fun showAll(dispatcher: CoroutineDispatcher = Dispatchers.IO)
    abstract fun handleClick(item: ChatUi, dispatcher: CoroutineDispatcher = Dispatchers.IO)
    abstract fun deleteItems(dispatcher: CoroutineDispatcher = Dispatchers.IO)

    fun updatedDataList(item: T): List<T> {
        val newList = mutableListOf<T>()
        showAllLiveData.value?.let { noteList ->
            newList.addAll(noteList)
        }
        newList.add(item)
        return newList
    }

    @JvmName("setPresenterF")
    fun setUiAction(UiAction: U) {
        this.activityUpdater = UiAction
    }

    override fun onCleared() {
        activityUpdater = null
        super.onCleared()
    }

    suspend fun updateUI(updatedList: List<T>) = withContext(Dispatchers.Main) {
        showAllLiveData.value = updatedList
    }

    protected fun scrollToLast(list: List<T>) {
        if (list.isNotEmpty())
            activityUpdater?.smoothScrollTo(list.lastIndex)
    }

    fun reload(isNeed: Boolean) {
        if (isNeed) showAll()
    }
}