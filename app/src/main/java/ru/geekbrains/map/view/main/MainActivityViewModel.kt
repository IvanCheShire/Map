package ru.geekbrains.map.view.main

import androidx.lifecycle.ViewModel
import ru.geekbrains.map.navigation.Screens
import ru.terrakok.cicerone.Router

class MainActivityViewModel (private val router: Router): ViewModel(){

    fun backPressed() {
        router.exit()
    }

    fun onCreate() {
        router.replaceScreen(ru.geekbrains.map.navigation.Screens.MapScreen())
    }

}