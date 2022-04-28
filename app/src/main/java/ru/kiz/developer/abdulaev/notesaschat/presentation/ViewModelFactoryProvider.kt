package ru.kiz.developer.abdulaev.notesaschat.presentation

import androidx.lifecycle.ViewModelProvider
import ru.kiz.developer.abdulaev.notesaschat.data.LocalDataSource
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor
import ru.kiz.developer.abdulaev.notesaschat.presentation.mapper.NoteToUiMapper

@Suppress("UNCHECKED_CAST")
interface ViewModelFactoryProvider {

    fun chatViewModelFactory(): ViewModelProvider.Factory
    fun noteViewModelFactory(chatId: Long): ViewModelProvider.Factory

    class Base(
        private val dataSource: LocalDataSource
    ) : ViewModelFactoryProvider {
        override fun chatViewModelFactory(): ViewModelProvider.Factory {
            val chatInteractor = ChatInteractor.Base(
                dataSource.chatDataSource(),
                dataSource.noteDataSource()
            )
            return ChatViewModelFactory(chatInteractor)
        }

        override fun noteViewModelFactory(chatId: Long): ViewModelProvider.Factory {
            val noteInteractor = NoteInteractor.Base(
                chatId,
                dataSource.noteDataSource(),
                NoteToUiMapper()
            )
            return NoteViewModelFactory(noteInteractor)
        }
    }
}