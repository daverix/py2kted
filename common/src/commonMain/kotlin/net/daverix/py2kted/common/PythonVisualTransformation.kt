package net.daverix.py2kted.common

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

private val KeyWords = listOf(
    "and",
    "as",
    "assert",
    "async",
    "await",
    "break",
    "class",
    "continue",
    "def",
    "del",
    "elif",
    "else",
    "except",
    "False",
    "finally",
    "for",
    "from",
    "global",
    "if",
    "import",
    "in",
    "is",
    "lambda",
    "None",
    "nonlocal",
    "not",
    "or",
    "pass",
    "raise",
    "return",
    "True",
    "try",
    "while",
    "with",
    "yield",
)

class PythonVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val builder = AnnotatedString.Builder(text)

        var currentWordStart = 0
        var index = 0
        val spacers = listOf(' ', '\n', '\r')
        while(index <= text.length) {
            if(index == text.length || text[index] in spacers) {
                val currentWord = text.substring(currentWordStart until index)
                if (currentWord in KeyWords) {
                    builder.addStyle(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = currentWordStart,
                        end = index
                    )
                }

                index++
                currentWordStart = index
            } else {
                index++
            }
        }

        return TransformedText(builder.toAnnotatedString(), offsetMapping = OffsetMapping.Identity)
    }
}
