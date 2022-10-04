package com.metehanbolat.uistructurecompose.components

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path

@Composable
fun heart(): GenericShape {
    return GenericShape { size, _ ->
        heartPath(size = size)
    }
}

fun Path.heartPath(size: Size): Path {

    val width: Float = size.width
    val height: Float = size.height

    moveTo(width / 2, height / 5)

    cubicTo(
        5 * width / 14, 0f,
        0f, height / 15,
        width / 28, 2 * height / 5
    )

    cubicTo(
        width / 14, 2 * height / 3,
        3 * width / 7, 5 * height / 6,
        width / 2, height
    )

    cubicTo(
        4 * width / 7, 5 * height / 6,
        13 * width / 14, 2 * height / 3,
        27 * width / 28, 2 * height / 5
    )

    cubicTo(
        width, height / 15,
        9 * width / 14, 0f,
        width / 2, height / 5
    )
    return this
}