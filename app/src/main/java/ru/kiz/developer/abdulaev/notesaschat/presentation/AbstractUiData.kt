package ru.kiz.developer.abdulaev.notesaschat.presentation

import ru.kiz.developer.abdulaev.notesaschat.core.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.presentation.view.ViewWrapper

abstract class AbstractUiData : ViewState, ContentEqual {
    private var viewWrapper: ViewWrapper? = null
    fun updateViewWrapper(viewWrapper: ViewWrapper) {
        this.viewWrapper = viewWrapper
    }

    override fun switchSelectionState():Boolean {
        return viewWrapper?.switchSelectionState() == true
    }

}