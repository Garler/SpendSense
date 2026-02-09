package pro.luntan.spendsense.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import pro.luntan.spendsense.common.ui.AppTheme
import pro.luntan.spendsense.common.ui.AppThemeProvider
import pro.luntan.spendsense.settings.SettingsViewModel
import pro.luntan.spendsense.settings.compose.SettingsScreen

@Composable
fun RootScreen(viewModel: RootViewModel) {

    val state by viewModel.state.collectAsState()

    AppTheme(
        themeIsDark = state.themeIsDark,
        appPrefs = state.appPrefs
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(AppThemeProvider.colors.background)
        ) {

            SettingsScreen(SettingsViewModel())
        }
    }
}