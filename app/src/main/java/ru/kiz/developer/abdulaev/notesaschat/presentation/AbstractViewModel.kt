package ru.kiz.developer.abdulaev.notesaschat.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class AbstractViewModel<T, U : UiUpdater.ActivityUpdater> : ViewModel(), BackPressHandler {
    abstract val showAllLiveData: MutableLiveData<List<T>>
    protected abstract var activityUpdater: U?
    protected abstract val selectionHandler: SelectionHandler<T>
    abstract fun showAll(dispatcher: CoroutineDispatcher = Dispatchers.IO)
    abstract fun handleClick(item: T, dispatcher: CoroutineDispatcher = Dispatchers.IO)
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
        updateState()
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

    protected fun updateState() {
        if (selectionHandler.isSelect())
            activityUpdater?.selectionState()
        else
            activityUpdater?.defaultState()
    }

    override fun onCleared() {
        activityUpdater = null
        super.onCleared()
    }

    override fun backPressed(): Boolean {
        if (selectionHandler.isSelect()) {
            selectionHandler.clear()
            updateState()
            return true
        }
        return false
    }
}