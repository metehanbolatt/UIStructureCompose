package com.metehanbolat.uistructurecompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.metehanbolat.uistructurecompose.R
import com.metehanbolat.uistructurecompose.components.rainbowcircle.colorList
import kotlin.math.roundToInt

@Composable
fun BankSample() {

    val rainbowColorsBrush = remember { Brush.sweepGradient(colorList) }
    val borderWidth = 4.dp

    var offsetX by remember { mutableStateOf(0f) }
    var offsetX3 by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    var offsetY3 by remember { mutableStateOf(0f) }

    var alpha by remember { mutableStateOf(0f) }
    var isPlaying by remember { mutableStateOf(false) }

    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        offset += offsetChange
        rotation += rotationChange
    }

    println("x: $offsetX")

    LaunchedEffect(key1 = offsetX) {
        if (offsetX in 210f..215f) {
            //offsetX = 999f
            scale += 0.5f
            //offsetX3 = 999f
        }
        if (offsetX >= 250) {
            offsetX3 += 999
            offset += Offset.Infinite
            offsetX += 999
            alpha += 1
            isPlaying = true
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null,
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotation,
                    translationX = offset.x,
                    translationY = offset.y
                )
                .transformable(state)
                .size(100.dp)
                .border(
                    BorderStroke(borderWidth, Color.Blue),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)

        )
        Image(
            painter = painterResource(id = R.drawable.lion),
            contentDescription = null,
            modifier = Modifier
                .offset { IntOffset(offsetX3.roundToInt(), offsetY3.roundToInt()) }
                .size(100.dp)
                .border(
                    BorderStroke(borderWidth, Color.Red),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX3 += dragAmount.x
                        offsetY3 += dragAmount.y
                    }
                }
        )
        Image(
            painter = painterResource(id = R.drawable.moneypng),
            contentDescription = null,
            modifier = Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .size(100.dp)
                .border(
                    BorderStroke(borderWidth, Color.Green),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        )
    }

    Box(modifier = Modifier.fillMaxSize().alpha(alpha), contentAlignment = Alignment.Center) {
        Lottie(isPlaying)
    }
}

@Composable
fun Lottie(isPlaying: Boolean) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.moneyt))
    LottieAnimation(composition = composition, isPlaying = isPlaying)
}

@Preview
@Composable
fun BankSamplePrev() {
    BankSample()
}