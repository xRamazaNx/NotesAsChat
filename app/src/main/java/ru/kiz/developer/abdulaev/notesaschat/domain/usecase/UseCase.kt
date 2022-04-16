package ru.kiz.developer.abdulaev.notesaschat.domain.usecase

interface UseCase<T> {
    fun execute(): T
}