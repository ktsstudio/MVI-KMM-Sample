package ru.kts.mobile.sample.di

import io.github.aakira.napier.Napier
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    Napier.d("initKoin")
    startKoin {
        appDeclaration()
        modules(
            mainModule,
        )
    }
}

// called by iOS
fun initKoinIos() = initKoin {}
