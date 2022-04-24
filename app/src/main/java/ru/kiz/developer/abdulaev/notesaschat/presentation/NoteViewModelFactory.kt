package ru.kiz.developer.abdulaev.notesaschat.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor
import ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel.NoteViewModel

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(
    private val noteInteractor: NoteInteractor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(noteInteractor) as T
    }
}