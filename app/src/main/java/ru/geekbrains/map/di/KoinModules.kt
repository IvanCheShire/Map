package ru.geekbrains.map.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.koin.dsl.module
import ru.geekbrains.map.model.data.DataModel
import ru.geekbrains.map.model.repository.Repository
import ru.geekbrains.map.model.repository.RepositoryImpl
import ru.geekbrains.map.view.main.MainActivityViewModel
import ru.geekbrains.map.view.mapscreen.MapViewModel
import ru.geekbrains.map.view.markerlistscreen.MarkerListViewModel
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Provider

class KoinModules {
    val application = module {
        single<Repository<List<DataModel>>> { RepositoryImpl() }

    }

    val viewModelModule = module {
        single<MutableMap<Class<out ViewModel>, Provider<ViewModel>>> {
            var map =
                mutableMapOf(
                    ru.geekbrains.map.view.main.MainActivityViewModel::class.java to Provider<ViewModel>{ MainActivityViewModel(get<Router>()) },
                    MapViewModel::class.java to Provider<ViewModel>{MapViewModel(get(), get<Router>()) },
                    MarkerListViewModel::class.java to Provider<ViewModel>{MarkerListViewModel(get(), get<Router>()) }
                )
            map
        }
        single<ViewModelProvider.Factory> { ViewModelFactory(get())}
    }

    val navigation = module {
        val cicerone: Cicerone<Router> = Cicerone.create()
        factory<NavigatorHolder> { cicerone.navigatorHolder }
        factory<Router> { cicerone.router }
    }

    val mainActivity = module {
        factory { MainActivityViewModel(get<Router>()) }
    }

    val mapScreen = module {
        factory { MapViewModel(get<Repository<List<DataModel>>>() as RepositoryImpl, get<Router>()) }
    }

    val markerListScreen = module {
        factory { MarkerListViewModel(get<Repository<List<DataModel>>>() as RepositoryImpl, get<Router>()) }
    }
}