package ru.kiz.developer.abdulaev.notesaschat.domain.interact

import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note

interface NoteInteractor : Interactor {
    fun note(id: Long): Note?
    fun allNotes(): List<Note>
    fun addNote(body: String): Note

    class Base(
        private val chatId: Long,
        private val noteRepo: Repository.NoteRepo<NoteEntity>
    ) : NoteInteractor {

        override fun note(id: Long): Note? {
            return noteRepo.getById(id)?.let { noteEntity ->
                Note(noteEntity)
            }
        }

        override fun allNotes(): List<Note> {
            return noteRepo.notesOfChat(chatId).fold(mutableListOf()) { list, noteEntity ->
                list.add(Note(noteEntity))
                list
            }
        }

        override fun addNote(body: String): Note {
            return noteRepo.create(chatId, body).let { noteEntityId ->
                note(noteEntityId)!!
            }
        }
    }
}
