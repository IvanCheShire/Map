package ru.geekbrains.map.navigation

import ru.geekbrains.map.view.mapscreen.MapFragment
import ru.geekbrains.map.view.markerlistscreen.MarkerListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class MapScreen() : SupportAppScreen() {
        override fun getFragment() = MapFragment.newInstance()
    }

    class MarkerListScreen(): SupportAppScreen() {
        override fun getFragment() = MarkerListFragment.newInstance()
    }
}