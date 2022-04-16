package ru.kiz.developer.abdulaev.notesaschat.domain.model

interface ContentEqual<T> {
    fun isEqualContent(content: T): Boolean
}