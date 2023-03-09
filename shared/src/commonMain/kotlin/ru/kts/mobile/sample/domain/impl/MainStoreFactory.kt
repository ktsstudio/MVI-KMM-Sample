package ru.kts.mobile.sample.domain.impl

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ru.kts.mobile.sample.data.Repository
import ru.kts.mobile.sample.domain.api.MainStore
import ru.kts.mobile.sample.domain.api.model.UserInfo

internal class MainStoreFactory(
    private val storeFactory: StoreFactory,
    private val repository: Repository,
) {

    fun create(): MainStore = object :
        MainStore,
        Store<MainStore.Intent, MainStore.State, Nothing> by storeFactory.create(
            name = MainStore::class.simpleName,
            initialState = MainStore.State(),
            bootstrapper = null,
            executorFactory = {
                MainExecutor(
                    repository = repository,
                )
            },
            reducer = MainReducer(),
        ) {}

    sealed interface Message {
        object SetLoading : Message
        data class SetUserInfo(val userInfo: UserInfo) : Message
        object SetError : Message
    }
}
