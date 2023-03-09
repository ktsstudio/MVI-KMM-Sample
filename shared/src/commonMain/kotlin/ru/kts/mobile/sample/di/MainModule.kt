package ru.kts.mobile.sample.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.logger.Logger
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import io.github.aakira.napier.Napier
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.kts.mobile.sample.common.Mapper
import ru.kts.mobile.sample.data.Repository
import ru.kts.mobile.sample.data.RepositoryImpl
import ru.kts.mobile.sample.domain.api.MainStore
import ru.kts.mobile.sample.domain.impl.MainStoreFactory
import ru.kts.mobile.sample.presentation.MainViewModel
import ru.kts.mobile.sample.presentation.mapper.MainUiStateMapper
import ru.kts.mobile.sample.presentation.model.UiMainState

@Suppress("RemoveExplicitTypeArguments")
internal val mainModule = module {

    factory<MainViewModel> {
        MainViewModel(
            store = get(),
            stateMapper = get(named("MainUiStateMapper")),
        )
    }

    factory<Mapper<MainStore.State, UiMainState>>(named("MainUiStateMapper")) {
        MainUiStateMapper()
    }

    factory<MainStore>() {
        MainStoreFactory(
            storeFactory = get(),
            repository = get(),
        ).create()
    }

    factory<StoreFactory> {
        val logger = object : Logger {
            override fun log(text: String) {
                Napier.v(text)
            }
        }
        LoggingStoreFactory(DefaultStoreFactory(), logger = logger)
    }

    factory<Repository>() {
        RepositoryImpl()
    }
}
