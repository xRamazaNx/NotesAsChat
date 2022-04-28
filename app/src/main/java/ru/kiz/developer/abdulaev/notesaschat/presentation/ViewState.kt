package ru.kiz.developer.abdulaev.notesaschat.presentation

interface ViewState<R> {
    fun switchState(): R
}