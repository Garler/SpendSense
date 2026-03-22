package pro.luntan.spendsense.events.list.compose

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch
import pro.luntan.spendsense.common.ui.atoms.FAB
import pro.luntan.spendsense.common.ui.atoms.RootBox
import pro.luntan.spendsense.common.ui.calendar.compose.CalendarColors
import pro.luntan.spendsense.common.ui.calendar.compose.DatePickerView
import pro.luntan.spendsense.common.ui.theme.AppThemeProvider
import pro.luntan.spendsense.di.DatePickerSingleQualifier
import pro.luntan.spendsense.di.getKoinInstance
import pro.luntan.spendsense.events.create.compose.CreateEventView
import pro.luntan.spendsense.events.list.EventsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxScope.EventsScreen(
    viewModel: EventsViewModel
) {

    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val state by viewModel.state.collectAsState()

    RootBox {
        Column {
            DatePickerView(
                viewModel = getKoinInstance(DatePickerSingleQualifier),
                colors = CalendarColors.default.copy(
                    colorSurface = AppThemeProvider.colors.surface,
                    colorOnSurface = AppThemeProvider.colors.onSurface,
                    colorAccent = AppThemeProvider.colors.accent
                ),
                firstDayIsMonday = AppThemeProvider.appPrefs.firstDayIsMonday,
                labels = state.calendarLabels,
                selectDayListener = viewModel::selectDay
            )

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(state.eventsByDay) { iventUI ->
                    SpendEventItem(iventUI)
                }
            }
        }

        FAB { showSheet = true }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showSheet = false
            },
            sheetState = sheetState,
            dragHandle = { ModalBottomSheetDefaults.properties },
            containerColor = Color.Transparent,
            modifier = Modifier.zIndex(1f)
        ) {
            CreateEventView(
                isExpand = true,
                selectedDay = state.selectedDay,
                viewModel = getKoinInstance()
            ) { newEvent ->
                viewModel.createEvent(newEvent)
                scope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showSheet = false
                    }
                }
            }
        }
    }
}