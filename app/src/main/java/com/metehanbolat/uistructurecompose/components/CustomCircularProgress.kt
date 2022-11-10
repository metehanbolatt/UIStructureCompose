package com.metehanbolat.uistructurecompose.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomCircularProgress(
    progress: Float
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )
    val progressStroke = 3.dp
    val circleStroke = 1.dp
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                drawCircle(
                    color = Color.Red,
                    alpha = 0.15f,
                    style = Stroke(width = circleStroke.toPx()),
                    radius = (size.minDimension - progressStroke.toPx()) / 2.0f
                )
            },
        progress = animatedProgress,
        color = MaterialTheme.colors.primary,
        strokeWidth = progressStroke
    )

}

@Preview(showBackground = true)
@Composable
fun CustomCircularProgressPreview() {
    CustomCircularProgress(progress = 50f)
}