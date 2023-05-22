import androidx.compose.ui.window.ComposeUIViewController
import com.example.sduiappkmm.App
import com.example.sduiappkmm.di.initKoin

fun MainViewController() = ComposeUIViewController { App() }

fun InitKoin() = initKoin()