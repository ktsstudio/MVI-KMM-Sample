package ru.kts.mobile.sample.android.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kts.mobile.sample.R
import ru.kts.mobile.sample.android.common.ui.buttonPrimaryActiveColor
import ru.kts.mobile.sample.android.common.ui.buttonPrimaryDisabledColor
import ru.kts.mobile.sample.android.common.ui.fontGilroy
import ru.kts.mobile.sample.android.common.ui.textPrimaryColor
import ru.kts.mobile.sample.android.common.ui.textSecondaryColor
import ru.kts.mobile.sample.android.common.widget.AppBar
import ru.kts.mobile.sample.domain.api.model.UserInfo
import ru.kts.mobile.sample.presentation.model.UiMainState

@Composable
internal fun MainScreen(
    state: UiMainState,
    onLoadClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(id = R.string.app_title),
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ) {
            val userInfo = state.userInfo

            when {
                state.error -> ErrorState(
                    modifier = Modifier
                        .align(Alignment.Center),
                    onLoadClick = onLoadClick,
                )
                state.loading -> CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = buttonPrimaryActiveColor,
                    strokeWidth = 3.dp,
                )
                userInfo != null -> UserInfoDetails(
                    modifier = Modifier
                        .align(Alignment.Center),
                    userInfo = userInfo,
                    onLoadClick = onLoadClick,
                )
            }
        }
    }
}

@Composable
private fun ErrorState(
    onLoadClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.error_title),
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            color = textSecondaryColor,
        )
        MainButton(
            modifier = Modifier
                .padding(top = 4.dp),
            titleResId = R.string.button_reload_title,
            onClick = onLoadClick,
        )
    }
}

@Composable
private fun MainButton(
    @StringRes titleResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        border = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonPrimaryActiveColor,
            disabledBackgroundColor = buttonPrimaryDisabledColor,
            contentColor = textPrimaryColor,
            disabledContentColor = textSecondaryColor,
        ),
        contentPadding = PaddingValues(8.dp),
    ) {
        Text(
            text = stringResource(titleResId),
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.sp,
            color = textPrimaryColor,
        )
    }
}

@Composable
private fun UserInfoDetails(
    userInfo: UserInfo,
    onLoadClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.name_title),
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textSecondaryColor,
        )
        Text(
            text = userInfo.name,
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textPrimaryColor,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.surname_title),
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textSecondaryColor,
        )
        Text(
            text = userInfo.surname,
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textPrimaryColor,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.birthday_title),
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textSecondaryColor,
        )
        Text(
            text = userInfo.birthDay,
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textPrimaryColor,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.gender_title),
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textSecondaryColor,
        )
        Text(
            text = userInfo.gender,
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textPrimaryColor,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.device_title),
            fontFamily = fontGilroy,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            color = textSecondaryColor,
        )
        Image(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_phone),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(4.dp))
        MainButton(
            modifier = Modifier
                .padding(top = 4.dp),
            titleResId = R.string.button_load_title,
            onClick = onLoadClick,
        )
    }
}
