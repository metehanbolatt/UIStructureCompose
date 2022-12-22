package com.metehanbolat.uistructurecompose.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SizeTextField() {

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {
            if (it.length < 6) {
                text = it
            }
        },
        enabled = text.length < 6
    )
}

@Preview(showBackground = true)
@Composable
fun SizeTextFieldPreview() {
    SizeTextField()
}