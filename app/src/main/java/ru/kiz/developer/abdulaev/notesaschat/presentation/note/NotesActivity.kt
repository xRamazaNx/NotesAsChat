package ru.kiz.developer.abdulaev.notesaschat.presentation.note

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import ru.kiz.developer.abdulaev.notesaschat.app
import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityNotesBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.CommonActivity
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.ChatActivity
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.view.NoteAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class NotesActivity : CommonActivity(), AbstractHolder.ClickListener<NoteUi> {
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

    override fun defaultState() {
        // TODO: set def menu
    }

    override fun selectionState() {
        // TODO: set selection menu
    }

    override fun initViews() {
        binding.send.isEnabled = false
        binding.inputEditText.addTextChangedListener {
            binding.send.isEnabled = it?.toString()?.isNotBlank() == true
        }
        binding.send.setOnClickListener {
            val body = binding.inputEditText.text.toString()
            viewModel.addNewNote(body)
            binding.inputEditText.setText("")
            setPositiveResult()
        }

        recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    override fun onClick(note: NoteUi) {
        // TODO: Handle it later
    }

    override fun onLongClick(t: NoteUi) {
        // TODO: Handle it later
    }

    // call this fun whenever change the chat (removed or added or changed)
    private fun setPositiveResult() {
        setResult(RESULT_OK)
    }
}