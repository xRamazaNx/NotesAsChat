package ru.kiz.developer.abdulaev.notesaschat.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ru.kiz.developer.abdulaev.notesaschat.data.store.NoteStore
import ru.kiz.developer.abdulaev.notesaschat.data.room.Room
import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityNotesBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.presenter.NotePresenter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.note.NoteAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel.NoteViewModel

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class NotesActivity : AppCompatActivity(), AbstractHolder.ClickListener<Note> {
    private val chatId: Long by lazy {
        intent.getLongExtra(ChatActivity.IEK_chatId, -1L)
    }
    private val binding by lazy {
        ActivityNotesBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<NoteViewModel> {
        val noteStore = NoteStore(Room.get(this).noteDao())
        val chatInteract = NoteInteractor.Base(chatId, noteStore)
        NoteViewModel.NoteViewModelFactory(chatInteract)
    }
    private val adapter = NoteAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (chatId == -1L) {
            finish()
            return
        }
        setContentView(binding.root)
        title = intent.getStringExtra(ChatActivity.IEK_chatName)
        val recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        recycler.adapter = adapter

        binding.send.setOnClickListener {
            viewModel.addNewNote()
        }

        viewModel.setPresenter(NotePresenter.Base(binding))
        viewModel.showAllLiveData.observe(this) { notes ->
            adapter.setList(notes)
        }
        viewModel.showAll()
    }

    override fun onClick(note: Note) {
        // TODO: Handle it later
    }
}