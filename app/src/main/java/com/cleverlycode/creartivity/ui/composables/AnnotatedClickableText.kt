package com.cleverlycode.creartivity.ui.composables

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun AnnotatedClickableText(
    text: String,
    clickableText: String,
    onClick: () -> Unit,
    tag: String,
    color: Color = Blue,
    fontWeight: FontWeight = FontWeight.Bold
) {
    val annotatedString = buildAnnotatedString {
        append(text)

        pushStringAnnotation(
            tag = tag,
            annotation = clickableText
        )

        withStyle(
            style = SpanStyle(
                color = color,
                fontWeight = fontWeight
            )
        ) {
            append(clickableText)
        }

        pop()
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = tag,
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                onClick()
            }
        }
    )
}