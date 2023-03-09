package ru.kts.mobile.sample.domain.impl

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kts.mobile.sample.common.Response
import ru.kts.mobile.sample.data.Repository
import ru.kts.mobile.sample.domain.api.MainStore

internal abstract class BaseExecutor<in Intent : Any, in Action : Any, in State : Any, Message : Any, Label : Any>(
    mainContext: CoroutineContext = Dispatchers.Main,
) : CoroutineExecutor<Intent, Action, State, Message, Label>(mainContext = mainContext) {

    final override fun executeIntent(intent: Intent, getState: () -> State) {
        scope.launch {
            suspendExecuteIntent(intent, getState)
        }
    }

    final override fun executeAction(action: Action, getState: () -> State) {
        scope.launch {
            suspendExecuteAction(action, getState)
        }
    }

    open suspend fun suspendExecuteIntent(intent: Intent, getState: () -> State) {}

    open suspend fun suspendExecuteAction(action: Action, getState: () -> State) {}
}

internal class MainExecutor(
    private val repository: Repository,
) : BaseExecutor<MainStore.Intent, Nothing, MainStore.State, MainStoreFactory.Message, Nothing>() {

    override suspend fun suspendExecuteIntent(
        intent: MainStore.Intent,
        getState: () -> MainStore.State,
    ) = when (intent) {
        is MainStore.Intent.Load -> loadUserInfo()
    }

    private suspend fun loadUserInfo() {
        dispatch(MainStoreFactory.Message.SetLoading)

        when (val response = repository.getUserInfo()) {
            is Response.Success -> dispatch(MainStoreFactory.Message.SetUserInfo(response.data))
            is Response.Failed -> dispatch(MainStoreFactory.Message.SetError)
        }
    }
}
