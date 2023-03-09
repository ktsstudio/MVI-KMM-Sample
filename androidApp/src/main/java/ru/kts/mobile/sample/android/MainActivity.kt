package ru.kts.mobile.sample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kts.mobile.sample.android.ui.MainScreen
import ru.kts.mobile.sample.di.initKoin
import ru.kts.mobile.sample.presentation.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin {
            androidContext(applicationContext)
        }

        setContent {
            val state by viewModel.state.collectAsState()

            MainScreen(
                state = state,
                onLoadClick = viewModel::load,
            )
        }
    }
}
