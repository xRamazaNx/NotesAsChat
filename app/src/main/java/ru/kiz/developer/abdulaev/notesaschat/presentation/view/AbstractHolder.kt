package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import android.widget.LinearLayout
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

abstract class AbstractHolder<T, B : ViewBinding>(
    protected val binding: B
) : ViewHolder(binding.root) {
    init {
        binding.root.layoutParams = LinearLayout.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    @CallSuper
    open fun bind(t: T, clickListener: ClickListener<T>) {
        binding.root.setOnClickListener {
            clickListener.onClick(t)
        }
    }

    interface ClickListener<T> {
        fun onClick(t: T)
    }
}