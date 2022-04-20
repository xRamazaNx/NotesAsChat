package ru.kiz.developer.abdulaev.notesaschat.core

// TODO: Как можно обозвать интерфейс который служит для
//  заполнения сущностей данными, например Intent?...
interface Filler<F : Filler.ValueFiller> {
    fun fill(filler: F)

    interface ValueFiller {
        interface ChatFiller : ValueFiller {
            fun fill(id: Long)
        }
    }
}