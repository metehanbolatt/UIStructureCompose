package com.metehanbolat.uistructurecompose.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimatedBorderCard(
    modifier: Modifier,
    contents: @Composable RowScope.() -> Unit
) {
    val containerSize = 200.dp
    var offsetFloat by remember { mutableStateOf(0f) }
    LaunchedEffect(null) {
        delay(200)
        offsetFloat = containerSize.value * 10f
    }
    val offset by animateFloatAsState(
        targetValue = offsetFloat,
        animationSpec = repeatable(
            iterations = 4,
            animation = tween(durationMillis = 3000, easing = LinearEasing),
        ),
    )

    val brush = Brush.linearGradient(
        shineColors,
        start = Offset(offset, offset),
        end = Offset(offset + containerSize.value * 40, offset + containerSize.value * 40),
        tileMode = TileMode.Repeated
    )

    Box(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
                .border(
                    width = 5.dp, brush = brush, shape = RoundedCornerShape(24.dp)
                )
                .background(Color(0xFFA9A9A9))
                .blur(2.dp),
        ) {
            contents()
        }
    }
}


private val shineColors = listOf(
    Color.White,
    Color(0xFFE91E63),
)