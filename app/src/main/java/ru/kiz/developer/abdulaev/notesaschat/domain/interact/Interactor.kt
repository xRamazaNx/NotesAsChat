package ru.kiz.developer.abdulaev.notesaschat.domain.interact

interface Interactor<T> {
    fun delete(items: List<T>)
}