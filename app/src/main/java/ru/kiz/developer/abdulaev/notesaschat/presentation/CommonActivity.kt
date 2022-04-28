package ru.kiz.developer.abdulaev.notesaschat.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

abstract class CommonActivity : AppCompatActivity(), UiUpdater.ActivityUpdater {
    protected lateinit var recycler: RecyclerView

    protected abstract fun initViews()

    override fun smoothScrollTo(position: Int) {
        recycler.smoothScrollToPosition(position)
    }

    override fun scrollTo(position: Int) {
        recycler.scrollToPosition(position)
    }
}