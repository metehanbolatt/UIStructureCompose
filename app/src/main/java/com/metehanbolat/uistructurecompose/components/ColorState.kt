package com.metehanbolat.uistructurecompose.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColorChangeState() {

    var isButtonEnabled by remember { mutableStateOf(true) }

    val animatedButtonColor = animateColorAsState(
        targetValue = if (isButtonEnabled) Color.Green else Color.Red,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = animatedButtonColor.value
            ),
            onClick = {
                isButtonEnabled = !isButtonEnabled
            }
        ) {
            Text(text = "Button")
        }
    }
}

@Preview
@Composable
fun ColorChangeStatePreview() {
    ColorChangeState()
}