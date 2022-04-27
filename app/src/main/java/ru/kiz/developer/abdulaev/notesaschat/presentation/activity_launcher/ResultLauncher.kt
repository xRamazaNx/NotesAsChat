package ru.kiz.developer.abdulaev.notesaschat.presentation.activity_launcher

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import ru.kiz.developer.abdulaev.notesaschat.core.Binder

abstract class ResultLauncher<R, B : Binder.DataBinder> {
    protected abstract val resultLauncher: ActivityResultLauncher<Intent>
    protected abstract var callback: (R) -> Unit
    abstract fun launch(binder: Binder<B>)
}