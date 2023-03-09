package ru.kts.mobile.sample.android.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import ru.kts.mobile.sample.R

val backgroundColor: Color
    @Composable get() = colorResource(id = R.color.background)

val borderColor: Color
    @Composable get() = colorResource(id = R.color.border)

val textPrimaryColor: Color
    @Composable get() = colorResource(id = R.color.textPrimary)

val textSecondaryColor: Color
    @Composable get() = colorResource(id = R.color.textSecondary)

val buttonPrimaryActiveColor: Color
    @Composable get() = colorResource(id = R.color.buttonPrimaryActive)

val buttonPrimaryDisabledColor: Color
    @Composable get() = colorResource(id = R.color.buttonPrimaryDisabled)
