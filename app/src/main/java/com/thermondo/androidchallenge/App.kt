package com.thermondo.androidchallenge

import android.app.Application
import de.alekseipopov.domain.di.domainModule
import de.alekseipopov.launches.di.launchesModule
import de.alekseipopov.network.di.networkModule
import de.alekseipopov.storage.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                domainModule,
                networkModule,
                storageModule,
                launchesModule
            )
        }
    }

}