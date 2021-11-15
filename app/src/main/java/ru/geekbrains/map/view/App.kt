package ru.geekbrains.map.view

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.geekbrains.map.di.*

class App: Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, viewModelModule, navigation, mainActivity, markerListScreen, mapScreen))
        }
    }

}