package ru.kiz.developer.abdulaev.notesaschat

import android.app.Application
import ru.kiz.developer.abdulaev.notesaschat.data.LocalDataSource
import ru.kiz.developer.abdulaev.notesaschat.presentation.ViewModelFactoryProvider

lateinit var app: App

class App : Application() {
    lateinit var dataSource: LocalDataSource
    lateinit var viewModelFactoryProvider: ViewModelFactoryProvider
    override fun onCreate() {
        super.onCreate()
        app = this
        dataSource = LocalDataSource.base(this)
        viewModelFactoryProvider = ViewModelFactoryProvider.Base(dataSource)
    }
}