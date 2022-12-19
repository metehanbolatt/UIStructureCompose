package com.metehanbolat.uistructurecompose.components.rainbowcircle

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.R

@Composable
fun RainbowCircle() {
    val rainbowColorsBrush = remember { Brush.sweepGradient(colorList) }
    val borderWidth = 4.dp

    Image(
        painter = painterResource(id = R.drawable.lion),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .border(
                BorderStroke(borderWidth, rainbowColorsBrush),
                CircleShape
            )
            .padding(borderWidth)
            .clip(CircleShape)
    )
}

@Preview
@Composable
fun RainbowCirclePreview() {
    RainbowCircle()
}

var colorList = listOf(
    Color(0xFF9575CD),
    Color(0xFFBA68C8),
    Color(0xFFE57373),
    Color(0xFFFFB74D),
    Color(0xFFFFF176),
    Color(0xFFAED581),
    Color(0xFF4DD0E1),
    Color(0xFF9575CD)
)