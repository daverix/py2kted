package net.daverix.py2kted.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var text by remember { mutableStateOf("") }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Python 2 Kotlin Editor")
                    }
                )
            }
        ) { padding ->
            Row(modifier = Modifier.padding(padding)) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(text = "Python")
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        value = text,
                        onValueChange = { value ->
                            text = value
                        }
                    )
                }
                Spacer(modifier = Modifier.fillMaxHeight().background(MaterialTheme.colors.onBackground).width(1.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(text = "Kotlin")
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(16.dp),
                        text = convertToKotlin(text)
                    )
                }
            }
        }
    }
}

private fun convertToKotlin(pythonCode: String): String {
    //TODO: convert the python code
    return pythonCode
}