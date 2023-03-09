package ru.kts.mobile.sample.presentation.model

import ru.kts.mobile.sample.domain.api.model.UserInfo

data class UiMainState internal constructor(
    val userInfo: UserInfo? = null,
    val loading: Boolean = true,
    val error: Boolean = false,
)
