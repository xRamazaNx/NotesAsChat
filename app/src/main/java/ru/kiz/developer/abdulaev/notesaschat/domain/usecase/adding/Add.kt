package ru.kiz.developer.abdulaev.notesaschat.domain.usecase.adding

import ru.kiz.developer.abdulaev.notesaschat.domain.interact.Interact
import ru.kiz.developer.abdulaev.notesaschat.domain.usecase.UseCase

abstract class Add<T, I : Interact>(
    protected val interact: I
) : UseCase<T> {
    protected abstract fun add(): T
    override fun execute() = add()
}