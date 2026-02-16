package pro.luntan.spendsense.root.model

import pro.luntan.spendsense.base.BaseViewState
import pro.luntan.spendsense.common.ui.AppPrefs

class RootContract {

    data class State(
        val themeIsDark: Boolean,
        val firstDayIsMonday: Boolean,
        val selectedTab: AppTab
    ) : BaseViewState {

        val appPrefs: AppPrefs
            get() = AppPrefs(firstDayIsMonday = firstDayIsMonday)

        companion object {
            val NONE = State(
                themeIsDark = true,
                firstDayIsMonday = true,
                selectedTab = AppTab.Events
            )
        }
    }
}