package pro.luntan.spendsense.settings

import pro.luntan.spendsense.base.BaseViewState

class SettingsContract {
    data class State(
        val info: String,
        val themeIsDark: Boolean
    ): BaseViewState {
        companion object {
            val NONE = State(
                info = "",
                themeIsDark = false
            )
        }
    }
}