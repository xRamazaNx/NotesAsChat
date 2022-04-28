package ru.kiz.developer.abdulaev.notesaschat.presentation

import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual

abstract class SelectionState : ViewState<Boolean>, ContentEqual {
    private var viewState: ViewState<Boolean>? = null
    fun updateViewWrapper(viewWrapper: ViewState<Boolean>) {
        this.viewState = viewWrapper
    }

    override fun switchState(): Boolean {
        return viewState?.switchState() == true
    }

}