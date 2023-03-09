package ru.kts.mobile.sample.domain.impl

import com.arkivanov.mvikotlin.core.store.Reducer
import ru.kts.mobile.sample.domain.api.MainStore

internal class MainReducer : Reducer<MainStore.State, MainStoreFactory.Message> {

    override fun MainStore.State.reduce(
        msg: MainStoreFactory.Message,
    ) = when (msg) {
        is MainStoreFactory.Message.SetError -> copy(
            isError = true,
            isLoading = false,
        )
        is MainStoreFactory.Message.SetUserInfo -> copy(
            details = msg.userInfo,
            isLoading = false,
        )
        is MainStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            isError = false,
        )
    }
}
