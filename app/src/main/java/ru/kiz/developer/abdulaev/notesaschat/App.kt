package ru.kiz.developer.abdulaev.notesaschat

import android.app.Application
import android.content.Context
import ru.kiz.developer.abdulaev.notesaschat.data.LocalDataSource

fun Context.app() = applicationContext as App

class App : Application() {
    lateinit var dataSource: LocalDataSource
    override fun onCreate() {
        super.onCreate()
        dataSource = LocalDataSource.baseRoom(this)
    }
}