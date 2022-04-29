package ru.kiz.developer.abdulaev.notesaschat.presentation

abstract class SelectionState : ViewState<Boolean> {
    private var isSelect = false

    override fun switchState(): Boolean {
        isSelect = !isSelect
        return isSelect
    }
}