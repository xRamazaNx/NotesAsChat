package ru.kiz.developer.abdulaev.notesaschat.domain.model

import ru.kiz.developer.abdulaev.notesaschat.core.ID

interface ContentEqual : ID {
    fun isEqualContent(content: ContentEqual): Boolean
}