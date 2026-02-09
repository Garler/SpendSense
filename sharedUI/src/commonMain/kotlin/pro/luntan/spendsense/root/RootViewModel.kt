package pro.luntan.spendsense.root

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pro.luntan.spendsense.base.BaseViewModel
import pro.luntan.spendsense.storage.SettingsManager

class RootViewModel: BaseViewModel<RootContract.State, Nothing>() {

    init {
        SettingsManager.themeIsDarkFlow.onEach { isDark ->
            updateState { copy(themeIsDark = isDark) }
        }.launchIn(viewModelScope)
    }

    override fun initialState() = RootContract.State.NONE


}