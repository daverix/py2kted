import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.daverix.py2kted.common.App


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Python 2 Kotlin Editor"
    ) {
        App()
    }
}
