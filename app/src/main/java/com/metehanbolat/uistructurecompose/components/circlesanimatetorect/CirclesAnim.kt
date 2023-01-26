package com.metehanbolat.uistructurecompose.components.circlesanimatetorect

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CirclesAnim() {

    var box1Rotate by remember { mutableStateOf(0f) }
    val rotateState1 by animateFloatAsState(
        targetValue = box1Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box2Rotate by remember { mutableStateOf(0f) }
    val rotateState2 by animateFloatAsState(
        targetValue = box2Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box3Rotate by remember { mutableStateOf(0f) }
    val rotateState3 by animateFloatAsState(
        targetValue = box3Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box4Rotate by remember { mutableStateOf(0f) }
    val rotateState4 by animateFloatAsState(
        targetValue = box4Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box5Rotate by remember { mutableStateOf(0f) }
    val rotateState5 by animateFloatAsState(
        targetValue = box5Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box6Rotate by remember { mutableStateOf(0f) }
    val rotateState6 by animateFloatAsState(
        targetValue = box6Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box7Rotate by remember { mutableStateOf(0f) }
    val rotateState7 by animateFloatAsState(
        targetValue = box7Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box8Rotate by remember { mutableStateOf(0f) }
    val rotateState8 by animateFloatAsState(
        targetValue = box8Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var box9Rotate by remember { mutableStateOf(0f) }
    val rotateState9 by animateFloatAsState(
        targetValue = box9Rotate,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    var changeShape by remember { mutableStateOf(175.dp) }
    val changeShapeState by animateDpAsState(
        targetValue = changeShape,
        animationSpec = tween(1000, 0, LinearEasing)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .size(350.dp)
                .rotate(rotateState1)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple1),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple1)
            )
        }
        Card(
            modifier = Modifier
                .size(310.dp)
                .rotate(rotateState2)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple2),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple2)
            )
        }
        Card(
            modifier = Modifier
                .size(270.dp)
                .rotate(rotateState3)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple3),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple3)
            )
        }
        Card(
            modifier = Modifier
                .size(230.dp)
                .rotate(rotateState4)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple4),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple4)
            )
        }
        Card(
            modifier = Modifier
                .size(190.dp)
                .rotate(rotateState5)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple5),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple5)
            )
        }
        Card(
            modifier = Modifier
                .size(150.dp)
                .rotate(rotateState6)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple6),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple6)
            )
        }
        Card(
            modifier = Modifier
                .size(110.dp)
                .rotate(rotateState7)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple7),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple7)
            )
        }
        Card(
            modifier = Modifier
                .size(70.dp)
                .rotate(rotateState8)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple8),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple8)
            )
        }
        Card(
            modifier = Modifier
                .size(30.dp)
                .rotate(rotateState9)
                .clip(RoundedCornerShape(changeShapeState))
                .background(Colors.purple9),
            elevation = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(changeShapeState))
                    .background(Colors.purple9)
            )
        }
    }

    var buttonChange by remember { mutableStateOf(true) }
    Column {
        Button(
            onClick = {
                if (buttonChange) {
                    box1Rotate = 20f
                    box2Rotate = 35f
                    box3Rotate = 50f
                    box4Rotate = 65f
                    box5Rotate = 80f
                    box6Rotate = 95f
                    box7Rotate = 110f
                    box8Rotate = 125f
                    box9Rotate = 140f
                    changeShape = 20.dp
                } else {
                    box1Rotate = 0f
                    box2Rotate = 0f
                    box3Rotate = 0f
                    box4Rotate = 0f
                    box5Rotate = 0f
                    box6Rotate = 0f
                    box7Rotate = 0f
                    box8Rotate = 0f
                    box9Rotate = 0f
                    changeShape = 175.dp
                }
                buttonChange = !buttonChange
            }
        ) {
            Text(text = "Animate")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CirclesAnimPreview() {
    CirclesAnim()
}

object Colors {
    val purple1 = Color(0xFF581C83)
    val purple2 = Color(0xFF6B20A2)
    val purple3 = Color(0xFF7E22C6)
    val purple4 = Color(0xFF9433E3)
    val purple5 = Color(0xFFA854F0)
    val purple6 = Color(0xFFBE85FA)
    val purple7 = Color(0xFFD9B4FB)
    val purple8 = Color(0xFFE9D5FC)
    val purple9 = Color(0xFFF3E8FE)
}