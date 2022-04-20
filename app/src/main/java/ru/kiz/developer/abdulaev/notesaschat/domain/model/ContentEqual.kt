package ru.kiz.developer.abdulaev.notesaschat.domain.model

interface ContentEqual {
    fun isEqualId(content: ContentEqual): Boolean
    fun isEqualContent(content: ContentEqual): Boolean
}