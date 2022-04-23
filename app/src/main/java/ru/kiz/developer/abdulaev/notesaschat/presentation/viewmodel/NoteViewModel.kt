package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.UiUpdater

class NoteViewModel(
    private val noteInteractor: NoteInteractor
) : AbstractViewModel<Note, UiUpdater.ActivityUpdater>() {
    override val showAllLiveData = MutableLiveData<List<Note>>()
    override var uiAction: UiUpdater.ActivityUpdater? = null

    fun addNewNote(
        body: String,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            val note = noteInteractor.addNote(body)
            val updatedList = updatedDataList(note)
            updateUI(updatedList)
            scrollToLast(updatedList)
        }
    }

    override fun showAll(dispatcher: CoroutineDispatcher) {
        viewModelScope.launch(dispatcher) {
            updateUI(noteInteractor.allNotes())
        }
    }

    class NoteViewModelFactory(
        private val noteInteract: NoteInteractor
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NoteViewModel(noteInteract) as T
        }
    }
}
