package ru.kiz.developer.abdulaev.notesaschat.presentation.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(
    private val noteInteractor: NoteInteractor<NoteUi>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(noteInteractor) as T
    }
}