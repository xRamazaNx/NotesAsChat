package ru.kiz.developer.abdulaev.notesaschat.presentation

abstract class SelectionState : ViewState<Boolean> {
    private var isSelect = false
    private var switchStateListener: ViewState.SwitchStateListener<Boolean>? = null

    override fun switchState(): Boolean {
        val newState = !isSelect
        isSelect = newState
        switchStateListener?.onSwitchState(newState)
        return newState
    }

    override fun setSwitchStateListener(switchStateListener: ViewState.SwitchStateListener<Boolean>) {
        switchStateListener.onBindState(isSelect)
        this.switchStateListener = switchStateListener
    }
}