package com.metehanbolat.uistructurecompose.components.bar_chart

import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.CustomBar(
    size: Dp,
    max: Float
) {
    val context = LocalContext.current
    var heightState by remember { mutableStateOf(0.dp) }
    val heightAnimate by animateDpAsState(
        targetValue = heightState,
        tween(durationMillis = 2000, delayMillis = 300, easing = LinearEasing),
        label = "Bar Height Animate"
    )

    LaunchedEffect(key1 = size) {
        heightState = size
    }

    Box(
        modifier = Modifier
            .padding(start = 4.dp, bottom = 0.dp, end = 4.dp, top = 4.dp)
            .size(heightAnimate)
            .weight(1f)
            .border(BorderStroke(1.dp, Color.Black))
            .background(Color.Red.copy(alpha = heightAnimate.value / max))
            .clickable {
                Toast
                    .makeText(context, "Value: $heightAnimate", Toast.LENGTH_SHORT)
                    .show()
            }
    )
}