package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import android.view.View
import android.widget.LinearLayout
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class AbstractHolder<T>(view: View) : ViewHolder(view) {
    init {
        view.layoutParams = LinearLayout.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    @CallSuper
    open fun bindHolder(t: T, clickListener: ClickListener<T>) {
        itemView.setOnClickListener {
            clickListener.onClick(t)
        }
    }

    interface ClickListener<T> {
        fun onClick(t: T)
    }
}