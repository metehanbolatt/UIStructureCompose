package com.metehanbolat.uistructurecompose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun Hexagon(
    modifier: Modifier = Modifier,
    isFilled: Boolean,
    icon: ImageVector? = null,
    hexagonColor: Color,
    backgroundColor: Color,
    iconTint: Color = Color.White,
    onClick: (() -> Unit)? = null,
    shouldAnimateLoadingBar: Boolean = false
) {

}