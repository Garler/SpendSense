package pro.luntan.spendsense.root.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import pro.luntan.spendsense.categories.CategoriesScreen
import pro.luntan.spendsense.common.ui.AppTheme
import pro.luntan.spendsense.common.ui.AppThemeProvider
import pro.luntan.spendsense.events.EventsScreen
import pro.luntan.spendsense.root.RootViewModel
import pro.luntan.spendsense.root.model.AppTab
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
            RootNavigation(state.selectedTab)
            RootBottomBar(state.selectedTab) { tab ->
                viewModel.handleClickOnTab(tab)
            }
        }
    }
}

@Composable
fun BoxScope.RootNavigation(selectedTab: AppTab) {
    when(selectedTab){
        AppTab.Categories -> CategoriesScreen()
        AppTab.Events -> EventsScreen()
        AppTab.Settings -> SettingsScreen(SettingsViewModel())
    }
}