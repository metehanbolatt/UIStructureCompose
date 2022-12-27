package com.metehanbolat.uistructurecompose.components.rainbowcircle

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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

    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        offset += offsetChange
        rotation += rotationChange
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotation,
                    translationX = offset.x,
                    translationY = offset.y,
                    alpha = scale / 2
                )
                .transformable(state = state)
                .size(200.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush),
                    CircleShape
                )
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