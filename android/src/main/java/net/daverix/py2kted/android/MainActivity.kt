package net.daverix.py2kted.android

import android.os.Bundle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.daverix.py2kted.common.App

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember { mutableStateOf("") }
            val scope = rememberCoroutineScope()
            val openDocumentLauncher = rememberLauncherForActivityResult(
                ActivityResultContracts.OpenDocument()
            ) { uri ->
                if(uri != null) {
                    scope.launch {
                        val textFromUri = withContext(Dispatchers.IO) {
                            contentResolver.openInputStream(uri)?.use {
                                it.bufferedReader().readText()
                            }
                        }
                        if(textFromUri != null) {
                            text = textFromUri
                        }
                    }
                }
            }
            MaterialTheme {
                App(
                    initialText = text,
                    onOpenDocument = {
                        openDocumentLauncher.launch(arrayOf("text/*"))
                    }
                )
            }
        }
    }
}