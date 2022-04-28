package ru.kiz.developer.abdulaev.notesaschat.presentation.chat

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import ru.kiz.developer.abdulaev.notesaschat.app
import ru.kiz.developer.abdulaev.notesaschat.core.Binder
import ru.kiz.developer.abdulaev.notesaschat.core.Binder.DataBinder
import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityChatBinding
import ru.kiz.developer.abdulaev.notesaschat.presentation.CommonActivity
import ru.kiz.developer.abdulaev.notesaschat.presentation.note.NoteActivityLauncher
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.presentation.chat.view.ChatAdapter


@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class ChatActivity : CommonActivity(), AbstractHolder.ClickListener<Binder<DataBinder.ChatBinder>> {
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

    override fun onClick(binder: Binder<DataBinder.ChatBinder>) {
        noteActivityResultLauncher.launch(binder)
    }


    override fun onLongClick(t: Binder<DataBinder.ChatBinder>) {
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