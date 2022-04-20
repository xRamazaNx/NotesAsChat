package ru.kiz.developer.abdulaev.notesaschat.core

interface Filler<F : Filler.ValueFiller> {
    fun fill(filler: F)

    interface ValueFiller {
        interface ChatFiller : ValueFiller {
            fun fill(id: Long)
        }
    }
}