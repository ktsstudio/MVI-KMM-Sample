package ru.kts.mobile.sample.domain.api

import com.arkivanov.mvikotlin.core.store.Store
import ru.kts.mobile.sample.domain.api.model.UserInfo

interface MainStore : Store<MainStore.Intent, MainStore.State, Nothing> {

    data class State internal constructor(
        val details: UserInfo? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        object Load : Intent
    }
}
