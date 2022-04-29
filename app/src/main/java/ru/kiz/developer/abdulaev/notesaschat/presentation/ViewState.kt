package ru.kiz.developer.abdulaev.notesaschat.presentation

interface ViewState<R> {
    fun switchState(): R
    fun setSwitchStateListener(switchStateListener: SwitchStateListener<R>)

    interface SwitchStateListener<R> {
        fun onSwitchState(state: R)
        fun onBindState(state: R)
    }
}