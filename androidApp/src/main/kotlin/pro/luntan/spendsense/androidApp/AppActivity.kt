package pro.luntan.spendsense.androidApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pro.luntan.spendsense.root.compose.RootScreen
import pro.luntan.spendsense.root.RootViewModel

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RootScreen(RootViewModel())
        }
    }
}
