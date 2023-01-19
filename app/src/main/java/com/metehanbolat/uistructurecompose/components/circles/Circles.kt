package com.metehanbolat.uistructurecompose.components.circles

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Circles() {
    val modifier = Modifier
        .fillMaxSize()
        .background(Color.White)

    Canvas(modifier = modifier) {
        val orbitRadius = 200f

        drawCircle(
            color = Color.Yellow,
            radius = 200f,
            center = Offset(this.center.x, this.center.y),
            style = Stroke(width = 10f)
        )

        (0..359 step 4).forEach { r ->
            val rad = Math.toRadians(r.toDouble())
            val x = (orbitRadius * cos(rad)).toFloat()
            val y = (orbitRadius * sin(rad)).toFloat()

            drawCircle(
                color = Color.Blue,
                radius = 100f,
                center = Offset(this.center.x + x, this.center.y + y),
                style = Stroke(width = 1f)
            )
        }
    }
}

@Preview
@Composable
fun CirclesPreview() {
    Circles()
}