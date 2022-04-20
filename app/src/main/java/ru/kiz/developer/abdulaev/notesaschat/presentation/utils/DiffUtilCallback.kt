package ru.kiz.developer.abdulaev.notesaschat.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import ru.kiz.developer.abdulaev.notesaschat.domain.model.ContentEqual

class DiffUtilCallback<T : ContentEqual> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.isEqualId(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.isEqualContent(newItem)
    }
}