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
            BoxWithConstraints {
                if(maxWidth > maxHeight) {
                    Row(modifier = Modifier.padding(padding)) {
                        PythonEditor(
                            text = text,
                            onChangeCode = {
                                text = it
                            },
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                        )
                        Spacer(
                            modifier = Modifier.fillMaxHeight()
                                .background(MaterialTheme.colors.onBackground)
                                .width(1.dp)
                        )
                        KotlinPreview(
                            text = text,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                        )
                    }
                } else {
                    Column(modifier = Modifier.padding(padding)) {
                        KotlinPreview(
                            text = text,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.4f)
                        )
                        Divider()
                        PythonEditor(
                            text = text,
                            onChangeCode = {
                                text = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.6f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun KotlinPreview(
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
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

@Composable
private fun PythonEditor(
    text: String,
    onChangeCode: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Python")
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            value = text,
            onValueChange = onChangeCode
        )
    }
}

private fun convertToKotlin(pythonCode: String): String {
    //TODO: convert the python code
    return pythonCode
}