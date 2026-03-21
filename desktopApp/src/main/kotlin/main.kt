import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import pro.luntan.spendsense.di.initKoin
import pro.luntan.spendsense.root.compose.RootScreen
import java.awt.Dimension

fun main() = application {

    initKoin()

    Window(
        title = "SpendSense",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(360, 600)
        RootScreen()
    }
}

