package ru.kts.mobile.sample.android.common.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kts.mobile.sample.R
import ru.kts.mobile.sample.android.common.ui.backgroundColor
import ru.kts.mobile.sample.android.common.ui.borderColor
import ru.kts.mobile.sample.android.common.ui.fontGilroy
import ru.kts.mobile.sample.android.common.ui.textPrimaryColor

val systemBarPaddingValues: PaddingValues
    @Composable get() = WindowInsets.systemBars
        .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
        .asPaddingValues()

@Composable
fun AppBar(
    title: String,
    modifier: Modifier = Modifier,
) = TopAppBar(
    modifier = modifier
        .defaultMinSize(minHeight = 64.dp),
    backgroundColor = backgroundColor,
    contentColor = textPrimaryColor,
    contentPadding = systemBarPaddingValues,
    elevation = 0.dp,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            text = title,
            fontFamily = fontGilroy,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            textAlign = TextAlign.Center,
            color = textPrimaryColor
        )
        Divider(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            color = borderColor,
        )
    }
}

@Composable
@Preview
private fun Preview() = AppBar(
    title = stringResource(id = R.string.app_title),
)
