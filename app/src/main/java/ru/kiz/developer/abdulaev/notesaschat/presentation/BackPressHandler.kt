package ru.kiz.developer.abdulaev.notesaschat.presentation

interface BackPressHandler {
    /** Returns true if in the implementation class something handled*/
    fun backPressed(): Boolean
}