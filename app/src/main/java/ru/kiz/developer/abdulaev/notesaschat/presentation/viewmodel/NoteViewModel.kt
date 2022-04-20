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
import ru.kiz.developer.abdulaev.notesaschat.domain.usecase.AddUseCase
import ru.kiz.developer.abdulaev.notesaschat.presentation.presenter.NotePresenter

abstract class NoteViewModel : ViewModelInterface<Note, NotePresenter>() {
    abstract fun addNewNote(
        addNoteCase: AddUseCase<Note, NoteInteractor>,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    )

    private class Base(
        private val noteInteractor: NoteInteractor
    ) : NoteViewModel() {
        override val showAllLiveData = MutableLiveData<List<Note>>()
        override var presenter: NotePresenter? = null

        override fun addNewNote(
            addNoteCase: AddUseCase<Note, NoteInteractor>,
            dispatcher: CoroutineDispatcher
        ) {
            viewModelScope.launch(dispatcher) {
                val note = addNoteCase.execute(noteInteractor)
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
    }

    class NoteViewModelFactory(
        private val noteInteract: NoteInteractor
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return Base(noteInteract) as T
        }
    }
}