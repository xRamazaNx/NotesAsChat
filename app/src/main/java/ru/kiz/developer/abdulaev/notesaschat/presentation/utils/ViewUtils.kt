package ru.kiz.developer.abdulaev.notesaschat.presentation.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun inflater(context: Context): LayoutInflater = LayoutInflater.from(context)

fun Context.inflate(
    @LayoutRes layout: Int,
    root: ViewGroup? = null,
    attachToRoot: Boolean = false
): View {
    return inflater(this).inflate(layout, root, attachToRoot)
}