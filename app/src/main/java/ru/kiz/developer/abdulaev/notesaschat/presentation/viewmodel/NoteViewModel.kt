package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteract
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding.AddNoteCase

abstract class NoteViewModel : ViewModel(), ViewModelInterface<Note> {
    abstract fun addNewNote(body: String)

    private class Base(
        private val noteInteract: NoteInteract
    ) : NoteViewModel() {
        override val showAllLiveData = MutableLiveData<List<Note>>()
        override fun addNewNote(body: String) {
            val addNoteCase = AddNoteCase(body, noteInteract)
            val note = addNoteCase.execute()
            update(note)
        }

        override fun showAll() {
            viewModelScope.launch(Dispatchers.IO) {
                val notes = noteInteract.allNotes()
                showAllLiveData.postValue(notes)
            }
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