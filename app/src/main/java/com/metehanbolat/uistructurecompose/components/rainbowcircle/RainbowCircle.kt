package com.metehanbolat.uistructurecompose.components.rainbowcircle

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.R

@Composable
fun RainbowCircle(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    val rainbowColorsBrush = remember { Brush.sweepGradient(colorList) }
    val borderWidth = 4.dp

    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(300.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush),
                    CircleShape
                )
                .rotate(angle)
                .padding(borderWidth)
                .clip(CircleShape)

        )

    }

}

@Preview
@Composable
fun RainbowCirclePreview() {
    RainbowCircle(R.drawable.lion)
}

val purple = Color(0xFF9575CD)
val pink = Color(0xFFBA68C8)
val red = Color(0xFFE57373)
val orange = Color(0xFFFFB74D)
val yellow = Color(0xFFFFF176)
val green = Color(0xFFAED581)
val blue = Color(0xFF4DD0E1)

var colorList = listOf(
    purple,
    pink,
    red,
    orange,
    yellow,
    green,
    blue,
    purple
)