package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData

interface ViewModelInterface<T> {
    val showAllLiveData: MutableLiveData<List<T>>
    fun showAll()
    fun update(item: T) {
        val newList = mutableListOf<T>()
        showAllLiveData.value?.let { noteList ->
            newList.addAll(noteList)
        }
        newList.add(item)
        showAllLiveData.postValue(newList.toList())
    }
}