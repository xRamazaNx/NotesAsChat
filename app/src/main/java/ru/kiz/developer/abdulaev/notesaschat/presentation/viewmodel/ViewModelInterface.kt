package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kiz.developer.abdulaev.notesaschat.presentation.Presenter

abstract class ViewModelInterface<T, P : Presenter.ActivityPresenter> : ViewModel() {
    abstract val showAllLiveData: MutableLiveData<List<T>>
    protected abstract var presenter: P?
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
    fun setPresenter(notePresenter: P) {
        this.presenter = notePresenter
    }

    override fun onCleared() {
        presenter = null
        super.onCleared()
    }

    suspend fun updateUI(updatedList: List<T>) = withContext(Dispatchers.Main) {
        showAllLiveData.value = updatedList
    }

    fun scrollToLast(list: List<T>) {
        if (list.isNotEmpty())
            presenter?.smoothScrollTo(list.lastIndex)
    }
}