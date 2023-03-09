package ru.kts.mobile.sample.presentation.mapper

import ru.kts.mobile.sample.common.Mapper
import ru.kts.mobile.sample.domain.api.MainStore
import ru.kts.mobile.sample.presentation.model.UiMainState

internal class MainUiStateMapper : Mapper<MainStore.State, UiMainState> {

    override fun map(item: MainStore.State) = UiMainState(
        userInfo = item.details,
        loading = item.isLoading,
        error = item.isError,
    )
}
