package pro.luntan.spendsense.root

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.luntan.spendsense.base.BaseViewModel
import pro.luntan.spendsense.root.model.AppTab
import pro.luntan.spendsense.root.model.RootContract
import pro.luntan.spendsense.storage.SettingsManager

class RootViewModel(
    private val settingsManager: SettingsManager
): BaseViewModel<RootContract.State, Nothing>() {

    init {
        settingsManager.themeIsDarkFlow.onEach { isDark ->
            updateState { copy(themeIsDark = isDark) }
        }.launchIn(viewModelScope)
    }

    override fun initialState() = RootContract.State.NONE

    fun handleClickOnTab(appTab: AppTab) = updateState { copy(selectedTab = appTab) }

}