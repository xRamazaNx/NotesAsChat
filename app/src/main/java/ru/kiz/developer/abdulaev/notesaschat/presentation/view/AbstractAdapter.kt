package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import androidx.recyclerview.widget.ListAdapter
import ru.kiz.developer.abdulaev.notesaschat.domain.model.ContentEqual
import ru.kiz.developer.abdulaev.notesaschat.presentation.utils.DiffUtilCallback

abstract class AbstractAdapter<T : ContentEqual, VH : AbstractHolder<T>>(
    private val clickListener: AbstractHolder.ClickListener<T>
) : ListAdapter<T, VH>(DiffUtilCallback<T>()) {

    fun setList(list: List<T>) = submitList(list)

    override fun onBindViewHolder(holder: VH, position: Int) {
        val note = getItem(position)
        holder.bind(note, clickListener)
    }
}