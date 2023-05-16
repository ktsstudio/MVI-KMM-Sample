package ru.kts.mobile.sample.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import ru.kts.mobile.sample.di.initKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(applicationContext)
        }
    }
}