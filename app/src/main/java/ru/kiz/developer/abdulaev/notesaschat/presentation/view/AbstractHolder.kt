package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import android.view.View
import android.widget.LinearLayout
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.kiz.developer.abdulaev.notesaschat.presentation.SelectionState

abstract class AbstractHolder<T : SelectionState, V : ViewWrapper>(
    view: View
) : ViewHolder(view) {
    protected abstract val viewWrapper: V

    init {
        view.layoutParams = LinearLayout.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    @CallSuper
    open fun bindHolder(t: T, clickListener: ClickListener<T>) {
        t.updateViewWrapper(viewWrapper)
        itemView.setOnClickListener {
            clickListener.onClick(t)
        }
        itemView.setOnLongClickListener {
            clickListener.onLongClick(t)
            true
        }
    }

    interface ClickListener<T> {
        fun onClick(t: T)
        fun onLongClick(t: T)
    }
}