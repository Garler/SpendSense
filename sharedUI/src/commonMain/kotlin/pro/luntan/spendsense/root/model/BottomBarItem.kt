package pro.luntan.spendsense.root.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.vectorResource
import spendsense.sharedui.generated.resources.Res
import spendsense.sharedui.generated.resources.*

data class BottomBarItem(
    val title: StringResource,
    val appTab: AppTab,
    val icon: ImageVector
) {
    companion object {
        @Composable
        fun getItems() = listOf(
            BottomBarItem(Res.string.events, AppTab.Events, vectorResource(Res.drawable.ic_calendar)),
            BottomBarItem(Res.string.categories, AppTab.Categories, vectorResource(Res.drawable.ic_categories)),
            BottomBarItem(Res.string.settings, AppTab.Settings, vectorResource(Res.drawable.ic_settings)),
        )
    }
}