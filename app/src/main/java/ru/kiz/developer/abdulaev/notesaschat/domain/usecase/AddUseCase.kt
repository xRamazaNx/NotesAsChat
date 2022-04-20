package ru.kiz.developer.abdulaev.notesaschat.domain.usecase

import ru.kiz.developer.abdulaev.notesaschat.domain.interact.ChatInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.Interactor
import ru.kiz.developer.abdulaev.notesaschat.domain.interact.NoteInteractor
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Chat
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note

abstract class AddUseCase<T, I : Interactor> : UseCase<T, I> {
    protected abstract fun add(interactor: I): T
    override fun execute(interactor: I) = add(interactor)

    class AddChat(
        private val name: String
    ) : AddUseCase<Chat, ChatInteractor>() {
        override fun add(interactor: ChatInteractor): Chat = interactor.addChat(name)
    }

    class AddNote(
        private val body: String
    ) : AddUseCase<Note, NoteInteractor>() {
        override fun add(interactor: NoteInteractor): Note = interactor.addNote(body)
    }
}