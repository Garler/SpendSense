package pro.luntan.spendsense.settings

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.luntan.spendsense.base.BaseViewModel
import pro.luntan.spendsense.platform.DeviceInfo
import pro.luntan.spendsense.settings.SettingsContract.*
import pro.luntan.spendsense.storage.SettingsManager


class SettingsViewModel(
    private val deviceInfo: DeviceInfo,
    private val settingsManager: SettingsManager
): BaseViewModel<State, Nothing>(){

    init {

        settingsManager.themeIsDarkFlow.onEach {
            updateState { copy(themeIsDark = it) }
        }.launchIn(viewModelScope)

        updateState {
            copy(info = deviceInfo.getSummary())
        }
    }

    override fun initialState(): State = State.NONE

    fun switchTheme(isDark: Boolean){
        settingsManager.themeIsDark = isDark
    }
}