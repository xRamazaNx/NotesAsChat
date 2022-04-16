package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

abstract class AbstractAdapter<T, B : ViewBinding, VH : AbstractHolder<T, B>>(
    private val clickListener: AbstractHolder.ClickListener<T>,
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffCallback) {

    fun setList(list: List<T>) = submitList(list)

    override fun onBindViewHolder(holder: VH, position: Int) {
        val note = getItem(position)
        holder.bind(note, clickListener)
    }
}