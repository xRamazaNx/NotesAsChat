package ru.kiz.developer.abdulaev.notesaschat.presentation

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

abstract class ResultLauncher<R> {
    protected abstract val resultLauncher: ActivityResultLauncher<Intent>
    protected abstract var callback: (R) -> Unit
    abstract fun launch(intent: Intent)
}