package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import android.view.View
import ru.kiz.developer.abdulaev.notesaschat.presentation.ViewState

abstract class ViewWrapper(
    private val root: View
) : ViewState {
    private var isSelect: Boolean = false

    override fun switchSelectionState(): Boolean {
        isSelect = !isSelect
        val offsetX = if (isSelect) 100f else 0f
        root.animate().translationX(offsetX).start()
        return isSelect
    }
}