package com.metehanbolat.uistructurecompose.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.R

enum class BoxState {
    START,
    END
}

@Composable
fun MainScreen() {
    var boxState by remember { mutableStateOf(BoxState.START) }
    val scale: Float by animateFloatAsState(
        targetValue = if (boxState == BoxState.START) 1f else 10f,
        animationSpec = keyframes {
            durationMillis = 1000
            5f.at(400).with(FastOutSlowInEasing)
            delayMillis = 50
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyObject(scale = scale)
        Button(
            onClick = {
                boxState = when (boxState) {
                    BoxState.START -> BoxState.END
                    BoxState.END -> BoxState.START
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(text = "Animate")
        }
    }
}

@Composable
fun MyObject(
    modifier: Modifier = Modifier,
    scale: Float
) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = modifier
            .scale(scale)
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}