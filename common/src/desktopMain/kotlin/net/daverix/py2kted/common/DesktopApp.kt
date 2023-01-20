package net.daverix.py2kted.common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

@Preview
@Composable
fun AppPreview() {
    App(
        initialText = "hello = world",
        onOpenDocument = {

        }
    )
}
