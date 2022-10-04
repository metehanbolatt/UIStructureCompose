package com.metehanbolat.uistructurecompose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomClickableText() {
    val uriTag = "URI"
    val uriHandler = LocalUriHandler.current
    val annotatedString = buildAnnotatedString {
        append("Metehan Bolat (Github)")
        addStyle(
            style = SpanStyle(textDecoration = TextDecoration.Underline),
            start = 15,
            end = 21
        )
        addStringAnnotation(
            tag = uriTag,
            annotation = "https://github.com/metehanie",
            start = 15,
            end = 21
        )
    }

    ClickableText(
        text = annotatedString,
        onClick = { position ->
            val annotations = annotatedString.getStringAnnotations(
                uriTag,
                start = position,
                end = position
            )
            annotations.firstOrNull()?.let {
                uriHandler.openUri(it.item)
            }
        },
        style = TextStyle(fontSize = 24.sp),
        modifier = Modifier.padding(8.dp)
    )
}