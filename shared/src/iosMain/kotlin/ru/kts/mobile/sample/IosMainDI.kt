package ru.kts.mobile.sample

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import ru.kts.mobile.sample.presentation.MainViewModel

class IosMainDI : KoinComponent {

    fun mainViewModel(): MainViewModel = get()
}
