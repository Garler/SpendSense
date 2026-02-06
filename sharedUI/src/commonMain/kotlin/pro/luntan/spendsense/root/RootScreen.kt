package pro.luntan.spendsense.root

import androidx.compose.runtime.Composable
import pro.luntan.spendsense.settings.compose.SettingsScreen
import pro.luntan.spendsense.settings.SettingsViewModel

@Composable
fun RootScreen(){
    SettingsScreen(SettingsViewModel())
}