package ru.kiz.developer.abdulaev.notesaschat.data

import ru.kiz.developer.abdulaev.notesaschat.core.ID

interface NoteEntity : ID {
    val chatId: Long
    val body: String
}