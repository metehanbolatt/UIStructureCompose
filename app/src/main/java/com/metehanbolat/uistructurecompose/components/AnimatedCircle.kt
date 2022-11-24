package com.metehanbolat.uistructurecompose.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedCircle() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {

        val animatable = remember { Animatable(0f) }

        LaunchedEffect(animatable) {
            animatable.animateTo(
                1f,
                animationSpec = tween(3000, easing = LinearEasing)
            )
        }

        Canvas(
            modifier = Modifier
                .size(400.dp)
                .padding(120.dp)
        ) {
            println(animatable.value)
            drawArc(
                color = Color.Red.copy(animatable.value),
                startAngle = 0f,
                sweepAngle = 360f * animatable.value,
                useCenter = false,
                size = Size(200f * 2, height = 200f * 2),
                style = Stroke(10f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedCirclePreview() {
    AnimatedCircle()
}