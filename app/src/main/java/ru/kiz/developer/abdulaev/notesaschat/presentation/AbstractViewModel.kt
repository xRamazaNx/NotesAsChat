package ru.kiz.developer.abdulaev.notesaschat.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class AbstractViewModel<T, U : UiUpdater.ActivityUpdater> : ViewModel() {
    abstract val showAllLiveData: MutableLiveData<List<T>>
    protected abstract var uiAction: U?
    abstract fun showAll(dispatcher: CoroutineDispatcher = Dispatchers.IO)
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
        this.uiAction = UiAction
    }

    override fun onCleared() {
        uiAction = null
        super.onCleared()
    }

    suspend fun updateUI(updatedList: List<T>) = withContext(Dispatchers.Main) {
        showAllLiveData.value = updatedList
    }

    protected fun scrollToLast(list: List<T>) {
        if (list.isNotEmpty())
            uiAction?.smoothScrollTo(list.lastIndex)
    }

    fun reload(isNeed: Boolean) {
        if (isNeed) showAll()
    }
}