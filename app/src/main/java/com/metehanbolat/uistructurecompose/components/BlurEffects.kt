package com.metehanbolat.uistructurecompose.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.R

@Composable
fun BlurEffects() {
    var checked by remember { mutableStateOf(false) }
    val animatedBlur by animateDpAsState(targetValue = if (checked) 10.dp else 0.dp)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(animatedBlur)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Switch(
                checked = checked,
                onCheckedChange = { checked = !checked }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlurEffectsPreview() {
    BlurEffects()
}