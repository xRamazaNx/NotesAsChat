package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import android.view.View
import androidx.annotation.CallSuper
import ru.kiz.developer.abdulaev.notesaschat.presentation.ViewState
import splitties.dimensions.dp

private const val checkIconWidth = 24F
private const val marginBetweenCheckIconAndInfoContainer = 16F
private const val translationOffset = checkIconWidth + marginBetweenCheckIconAndInfoContainer

abstract class ViewWrapper(
    private val root: View
) : ViewState.SwitchStateListener<Boolean> {
    @CallSuper
    override fun onSwitchState(state: Boolean) {
        val offsetX = if (state) root.dp(translationOffset) else 0f
        root.animate().translationX(offsetX).start()
    }

    @CallSuper
    override fun onBindState(state: Boolean) {
        val offsetX = if (state) root.dp(translationOffset) else 0f
        root.translationX = offsetX
    }
}