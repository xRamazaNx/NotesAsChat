package ru.kiz.developer.abdulaev.notesaschat.presentation.view

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.viewbinding.ViewBinding

abstract class AbstractAdapter<T, B : ViewBinding, H : AbstractHolder<T, B>>(
    private val clickListener: AbstractHolder.ClickListener<T>
) : Adapter<H>() {
    private val notes: MutableList<T> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<T>) {
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: H, position: Int) {
        val note = notes[position]
        holder.bind(note, clickListener)
    }

    override fun getItemCount(): Int = notes.size
}