package ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor
import ru.kiz.developer.abdulaev.notesaschat.presentation.NoteUi
import ru.kiz.developer.abdulaev.notesaschat.presentation.UiUpdater

class NoteViewModel(
    private val noteInteractor: NoteInteractor<NoteUi>
) : AbstractViewModel<NoteUi, UiUpdater.ActivityUpdater>() {
    override val showAllLiveData = MutableLiveData<List<NoteUi>>()
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
}
