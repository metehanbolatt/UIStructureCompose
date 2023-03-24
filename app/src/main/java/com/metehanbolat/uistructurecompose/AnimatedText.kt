package com.metehanbolat.uistructurecompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun AnimatedTextPreview() {
    Text(
        text = "Metehan Bolat",
        modifier = Modifier.width(150.dp).basicMarquee(
            animationMode = MarqueeAnimationMode.Immediately,
            delayMillis = 0
        ),
        fontSize = 50.sp
    )
    

}