package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteract
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding.AddNoteCase
import ru.kiz.developer.abdulaev.notesaschat.presentation.presenter.NotePresenter

abstract class NoteViewModel : ViewModel(), ViewModelInterface<Note> {
    abstract fun setPresenter(notePresenter: NotePresenter)
    abstract fun addNewNote(
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    )

    private class Base(
        private val noteInteract: NoteInteract
    ) : NoteViewModel() {
        private var notePresenter: NotePresenter? = null
        override val showAllLiveData = MutableLiveData<List<Note>>()

        override fun setPresenter(notePresenter: NotePresenter) {
            this.notePresenter = notePresenter
        }

        override fun addNewNote(
            dispatcher: CoroutineDispatcher
        ) {
            val presenter = notePresenter ?: return
            val body = presenter.noteBody()
            if (body.isNotBlank()) {
                viewModelScope.launch(dispatcher) {
                    val addNoteCase = AddNoteCase(body, noteInteract)
                    val note: Note = addNoteCase.execute()
                    val updatedList = updatedDataList(note)
                    withContext(Dispatchers.Main) {
                        showAllLiveData.value = updatedList
                        if (updatedList.isNotEmpty())
                            presenter.smoothScrollTo(updatedList.lastIndex)
                    }
                }
            }
            presenter.clearBody()
        }

        override fun showAll() {
            viewModelScope.launch(Dispatchers.IO) {
                val notes = noteInteract.allNotes()
                withContext(Dispatchers.Main) {
                    showAllLiveData.value = notes
                    notePresenter?.scrollTo(notes.lastIndex)
                }
            }
        }

        override fun onCleared() {
            notePresenter = null
            super.onCleared()
        }
    }

    class NoteViewModelFactory(
        private val noteInteract: NoteInteract
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return Base(noteInteract) as T
        }
    }
}