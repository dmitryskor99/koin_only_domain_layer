package ru.dmitryskor.koin_only_domain_layer

import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify
import ru.dmitryskor.koin_only_domain_layer.di.dataStoreModule
import ru.dmitryskor.koin_only_domain_layer.di.repositoryModule
import ru.dmitryskor.koin_only_domain_layer.di.useCaseModule

//import ru.dmitryskor.koin_only_domain_layer.di.appModule

class CheckModulesTest : KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() {
        dataStoreModule.verify()
        repositoryModule.verify()
        useCaseModule.verify()
//        AppModule().module.verify()
    }
}