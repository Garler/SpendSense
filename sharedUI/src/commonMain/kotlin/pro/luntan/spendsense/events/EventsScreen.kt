package pro.luntan.spendsense.events

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pro.luntan.spendsense.common.ui.calendar.compose.CalendarColors
import pro.luntan.spendsense.common.ui.calendar.compose.DatePickerView
import pro.luntan.spendsense.common.ui.theme.AppThemeProvider
import pro.luntan.spendsense.di.getKoinInstance

@Composable
fun BoxScope.EventsScreen() {
    DatePickerView(
        viewModel = getKoinInstance(),
        colors = CalendarColors.default.copy(
            colorSurface = AppThemeProvider.colors.surface,
            colorOnSurface = AppThemeProvider.colors.onSurface,
            colorAccent = AppThemeProvider.colors.accent
        ),
        firstDayIsMonday = AppThemeProvider.appPrefs.firstDayIsMonday,
        labels = emptyList(),
        selectDayListener = { day -> }
    )
}