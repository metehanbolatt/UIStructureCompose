package com.metehanbolat.uistructurecompose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedHeart() {

    var isVisible by remember { mutableStateOf(false) }

    Button(onClick = { isVisible = !isVisible }) {
        Text(text = if (isVisible) "Hide" else "Show")
    }
    Spacer(modifier = Modifier.size(150.dp))
    AnimatedVisibility(
        visible = isVisible,
        exit = fadeOut(animationSpec = tween(1000, easing = LinearEasing)),
        enter = fadeIn(animationSpec = tween(1000, easing = LinearEasing))
    ) {
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(Color.Red, shape = heart())
        )
    }
}