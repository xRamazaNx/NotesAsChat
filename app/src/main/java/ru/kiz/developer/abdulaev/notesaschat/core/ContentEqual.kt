package ru.kiz.developer.abdulaev.notesaschat.core

interface ContentEqual {
    fun isEqualId(content: ContentEqual): Boolean
    fun isEqualContent(content: ContentEqual): Boolean
}