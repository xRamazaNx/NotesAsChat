package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import ru.kiz.developer.abdulaev.notesaschat.app
import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityChatBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.CommonActivity
import ru.kiz.developer.abdulaev.notesaschat.presentation.UiUpdater.ActivityUpdater.ChatActivityUpdater
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.view.ChatAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.mapper.ChatOpenIntentMapper
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteActivityLauncher
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NotesActivity
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder


@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class ChatActivity : CommonActivity(), AbstractHolder.ClickListener<ChatUi>,
    ChatActivityUpdater<ChatUi> {
    companion object {
        const val IEK_chatId = "chat_id" // Intent Extra Key
        const val IEK_chatName = "chat_name" // Intent Extra Key
    }

    private val binding by lazy {
        ActivityChatBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<ChatViewModel> {
        app.viewModelFactoryProvider.chatViewModelFactory()
    }
    private val adapter = ChatAdapter(this)

    private val noteActivityResultLauncher = NoteActivityLauncher(this) { result ->
        viewModel.reload(result)
    }

    override fun onClick(chatUi: ChatUi) {
        viewModel.handleClick(chatUi, false)
    }

    override fun openChat(chatUi: ChatUi) {
        val intentMapper = ChatOpenIntentMapper(this, NotesActivity::class.java)
        val intent = chatUi.map(intentMapper)
        noteActivityResultLauncher.launch(intent)
    }

    override fun onLongClick(chatUi: ChatUi) {
        viewModel.handleClick(chatUi, true)
    }

    override fun onBackPressed() {
        if (viewModel.backPressed())
            return
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        viewModel.setUiAction(this)
        viewModel.showAllLiveData.observe(this) { chats ->
            adapter.setList(chats)
        }
        viewModel.showAll()
    }

    override fun defaultState() = runOnUiThread {
        // TODO: set def menu R.menu.chat_main_menu
    }

    override fun selectionState() = runOnUiThread {
        // TODO: set selection menu R.menu.chat_selection_menu
    }

    override fun initViews() {
        recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(
            MaterialDividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            ).apply { dividerThickness = 1 }
        )
        recycler.adapter = adapter

        binding.addChatBtn.setOnClickListener {
            viewModel.addNewChat("New chat of notes")
        }
    }
}