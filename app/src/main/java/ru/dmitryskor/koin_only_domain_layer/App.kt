package ru.dmitryskor.koin_only_domain_layer

import android.app.Application
import org.koin.core.context.startKoin
import ru.dmitryskor.koin_only_domain_layer.di.dataStoreModule
import ru.dmitryskor.koin_only_domain_layer.di.repositoryModule
import ru.dmitryskor.koin_only_domain_layer.di.useCaseModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                repositoryModule,
                useCaseModule,
                dataStoreModule
            )
        }
    }
}