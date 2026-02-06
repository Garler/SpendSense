package pro.luntan.spendsense.settings

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.luntan.spendsense.base.BaseViewModel
import pro.luntan.spendsense.platform.DeviceInfo
import pro.luntan.spendsense.settings.SettingsContract.*
import pro.luntan.spendsense.storage.SettingsManager

class SettingsViewModel: BaseViewModel<State, Nothing>(){

    init {

        SettingsManager.themeIsDarkFlow.onEach {
            updateState { copy(themeIsDark = it) }
        }.launchIn(viewModelScope)

        val deviceInfo = DeviceInfo()
        updateState {
            copy(deviceInfo = deviceInfo.getSummary())
        }
    }

    override fun initialState(): State = State.NONE

    fun switchTheme(isDark: Boolean){
        SettingsManager.themeIsDark = isDark
    }
}