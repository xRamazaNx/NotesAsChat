package ru.kiz.developer.abdulaev.notesaschat.domain.usecase

import ru.kiz.developer.abdulaev.notesaschat.domain.interact.Interactor

interface UseCase<T, I : Interactor> {
    fun execute(interactor: I): T
}