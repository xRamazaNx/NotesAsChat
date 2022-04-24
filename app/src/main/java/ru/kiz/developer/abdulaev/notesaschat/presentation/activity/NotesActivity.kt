package ru.kiz.developer.abdulaev.notesaschat.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ru.kiz.developer.abdulaev.notesaschat.app
import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityNotesBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.note.NoteAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel.NoteViewModel

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class NotesActivity : CommonActivity(), AbstractHolder.ClickListener<Note> {
    private val chatId: Long by lazy {
        intent.getLongExtra(ChatActivity.IEK_chatId, -1L)
    }
    private val binding by lazy {
        ActivityNotesBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<NoteViewModel> {
        app.viewModelFactoryProvider.noteViewModelFactory(chatId)
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

        initViews()

        viewModel.setUiAction(this)
        viewModel.showAllLiveData.observe(this) { notes ->
            adapter.setList(notes)
        }
        viewModel.showAll()
    }

    override fun initViews() {
        recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        recycler.adapter = adapter
        binding.send.isEnabled = false

        binding.inputEditText.addTextChangedListener {
            binding.send.isEnabled = it?.toString()?.isNotBlank() == true
        }

        binding.send.setOnClickListener {
            val body = binding.inputEditText.text.toString()
            viewModel.addNewNote(body)
            binding.inputEditText.setText("")
        }
    }

    override fun onClick(note: Note) {
        // TODO: Handle it later
    }
}