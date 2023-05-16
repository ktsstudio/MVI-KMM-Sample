package ru.kts.mobile.sample.presentation

import com.arkivanov.mvikotlin.core.binder.Binder
import com.arkivanov.mvikotlin.extensions.coroutines.BindingsBuilder
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.states
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import ru.kts.mobile.sample.common.Mapper
import ru.kts.mobile.sample.domain.api.MainStore
import ru.kts.mobile.sample.presentation.model.UiMainState

class MainViewModel(
    private val store: MainStore,
    private val stateMapper: Mapper<MainStore.State, UiMainState>,
) : ViewModel() {

    val state: CStateFlow<UiMainState>
        get() = mutableState.cStateFlow()

    private val initialState = UiMainState()

    private val mutableState = MutableStateFlow(initialState).cMutableStateFlow()

    private val binder: Binder

    init {
        binder = bind(Dispatchers.Main.immediate) {
            store.states.map(stateMapper::map) bindTo (::acceptState)
        }
        binder.start()

        load()
    }

    fun load() = store.accept(MainStore.Intent.Load)

    private fun acceptState(state: UiMainState) {
        mutableState.value = state
    }

    override fun onCleared() {
        super.onCleared()
        binder.stop()
        store.dispose()
    }
}
