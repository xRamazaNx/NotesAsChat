package ru.kiz.developer.abdulaev.notesaschat.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ru.kiz.developer.abdulaev.notesaschat.core.Filler
import ru.kiz.developer.abdulaev.notesaschat.data.store.ChatStore
import ru.kiz.developer.abdulaev.notesaschat.data.store.NoteStore
import ru.kiz.developer.abdulaev.notesaschat.data.room.Room
import ru.kiz.developer.abdulaev.notesaschat.databinding.ActivityChatBinding
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.presentation.presenter.ChatPresenter
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.AbstractHolder
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.chat.ChatAdapter
import ru.kiz.developer.abdulaev.notesaschat.presentation.viewmodel.ChatViewModel


@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class ChatActivity : AppCompatActivity(), AbstractHolder.ClickListener<Chat> {
    companion object {
        const val IEK_chatId = "chat_id" // Intent Extra Key
        const val IEK_chatName = "chat_name" // Intent Extra Key
    }

    private val binding by lazy {
        ActivityChatBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<ChatViewModel> { chatViewModelFactory() }
    private val adapter = ChatAdapter(this)

    override fun onClick(chat: Chat) {
        val intent = Intent(this, NotesActivity::class.java)
        chat.fill(object : Filler.ValueFiller.ChatFiller {
            override fun fill(id: Long, name: String) {
                intent.putExtra(IEK_chatId, id)
                intent.putExtra(IEK_chatName, name)
            }
        })
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        recycler.adapter = adapter

        binding.addChatBtn.setOnClickListener {
            viewModel.addNewChat("New chat of notes")
        }

        viewModel.setPresenter(ChatPresenter.Base(binding))
        viewModel.showAllLiveData.observe(this) { chats ->
            adapter.setList(chats)
        }
        viewModel.showAll()
    }

    private fun chatViewModelFactory(): ChatViewModel.ChatViewModelFactory {
        val room = Room.get(this)
        val noteStore = NoteStore(room.noteDao())
        val chatStore = ChatStore(room.chatDao())
        val chatInteractor = ChatInteractor.Base(chatStore, noteStore)
        return ChatViewModel.ChatViewModelFactory(chatInteractor)
    }
}