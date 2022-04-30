package ru.kiz.developer.abdulaev.notesaschat.domain.interact

import ru.kiz.developer.abdulaev.notesaschat.core.Mapper
import ru.kiz.developer.abdulaev.notesaschat.core.Repository
import ru.kiz.developer.abdulaev.notesaschat.data.mapper.NoteDomainToDataMapper
import ru.kiz.developer.abdulaev.notesaschat.data.NoteEntity
import ru.kiz.developer.abdulaev.notesaschat.domain.model.Note

interface NoteInteractor<U> : Interactor<Note> {
    fun note(id: Long): U?
    fun allNotes(): List<U>
    fun addNote(body: String): U

    class Base<U>(
        private val chatId: Long,
        private val noteRepo: Repository.NoteRepo<NoteEntity>,
        private val noteToUiMapper: Mapper.NoteMapper<U>
    ) : NoteInteractor<U> {

        override fun note(id: Long): U? {
            return noteRepo.getById(id)?.let { noteEntity ->
                Note(noteEntity).map(noteToUiMapper)
            }
        }

        override fun allNotes(): List<U> {
            return noteRepo.notesOfChat(chatId).fold(mutableListOf()) { list, noteEntity ->
                list.add(Note(noteEntity).map(noteToUiMapper))
                list
            }
        }

        override fun addNote(body: String): U {
            return noteRepo.create(chatId, body).let { noteEntityId ->
                note(noteEntityId)!!
            }
        }

        override fun delete(items: List<Note>) {
            items.forEach { note ->
                noteRepo.delete(note.map(NoteDomainToDataMapper(chatId)))
            }
        }
    }
}
