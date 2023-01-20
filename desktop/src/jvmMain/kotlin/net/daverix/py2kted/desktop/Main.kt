package net.daverix.py2kted.desktop

import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.daverix.py2kted.common.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Python 2 Kotlin Editor"
    ) {
        var text by remember { mutableStateOf("") }
        val scope = rememberCoroutineScope()
        var fileDialogOpen by remember { mutableStateOf(false) }

        App(
            initialText = text,
            onOpenDocument = {
                fileDialogOpen = true
            },
            extraButtons = {

            }
        )

        if(fileDialogOpen) {
            FileDialog(
                onCloseRequest = { result ->
                    fileDialogOpen = false
                    text = result ?: "error"
                }
            )
        }
    }
}

