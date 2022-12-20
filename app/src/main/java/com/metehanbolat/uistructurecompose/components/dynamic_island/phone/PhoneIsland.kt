package com.metehanbolat.uistructurecompose.components.dynamic_island.phone

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.metehanbolat.uistructurecompose.R
import com.metehanbolat.uistructurecompose.components.rainbowcircle.RainbowCircle

@ExperimentalMotionApi
@ExperimentalUnitApi
@Preview
@Composable
fun DynamicIsland() {
    var expanded by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (expanded) 1f else 0f,
        animationSpec = tween(1000)
    )
    var colorBackgroundState by remember { mutableStateOf(Color.Black) }

    var heightState by remember { mutableStateOf(48.dp) }
    var widthState by remember { mutableStateOf(196.dp) }
    var percentCornerState by remember {
        mutableStateOf(50)
    }
    var fontSizeState by remember {
        mutableStateOf(18.sp)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), Alignment.TopCenter
    ) {
        MotionLayout(
            modifier = Modifier
                .width(widthState)
                .height(heightState)
                .clip(shape = RoundedCornerShape(percent = 50))
                .clickable { expanded = !expanded },
            motionScene = getMotionSceneForDemo1(),
            progress = progress
        ) {
            val colorBackground = motionProperties(id = "surface").value.color("color")
            colorBackground.let { colorBackgroundState = it }

            val newHeight = motionProperties(id = "surface").value.float("height")
            newHeight.let { heightState = it.dp }

            val newWidth = motionProperties(id = "surface").value.float("width")
            newWidth.let { widthState = it.dp }

            val percentCorner = motionProperties(id = "surface").value.int("corner")
            percentCorner.let { percentCornerState = it }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(percent = 50))
                    .layoutId("surface")
                    .background(colorBackgroundState)
            )
            val color = Color.fromHex("#76ff03")
            Icon(
                modifier = Modifier
                    .size(28.dp)
                    .layoutId("icCall"),
                painter = painterResource(id = R.drawable.ic_icbaselinecall),
                contentDescription = "",
                tint = color
            )

            Icon(
                modifier = Modifier
                    .size(28.dp)
                    .layoutId("icVoice"),
                painter = painterResource(id = R.drawable.ic_icoutlinekeyboardvoice),
                contentDescription = "",
                tint = color
            )

            val fontSize = motionProperties(id = "durationLabel").value.float("size")
            fontSize.let { fontSizeState = TextUnit(fontSize, TextUnitType.Sp) }
            Text(
                text = "3:42",
                color = color,
                fontSize = 18.sp,
                modifier = Modifier.layoutId("durationLabel")
            )
            Text(
                text = "Metehan",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.layoutId("nameLabel")
            )
            Text(
                text = "Bolat",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.layoutId("lastNameLabel")
            )
            RainbowCircle(
                image = R.drawable.avatar,
                modifier = Modifier
                    .layoutId("avatar")
                    .size(64.dp)
                    .clip(CircleShape)
            )

            CallIcon(
                modifier = Modifier.layoutId("startCall"),
                R.drawable.ic_icbaselinecall,
                Color.Green
            )
            CallIcon(
                modifier = Modifier.layoutId("endCall"),
                R.drawable.ic_icbaselinecallend,
                Color.Red
            )
        }
    }
}

private fun Color.Companion.fromHex(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}


@Composable
fun CallIcon(modifier: Modifier = Modifier, icon: Int, backgroundColor: Color) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(28.dp)
                .layoutId("icCall"),
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = Color.White
        )
    }
}

@SuppressLint("Range")
@ExperimentalMotionApi
@Composable
fun getMotionSceneForDemo1(): MotionScene {
    return MotionScene {
        val start1 = constraintSet {
            val surface = createRefFor("surface")
            val avatar = createRefFor("avatar")
            val nameLabel = createRefFor("nameLabel")
            val lastNameLabel = createRefFor("lastNameLabel")
            val icCall = createRefFor("icCall")
            val icVoice = createRefFor("icVoice")
            val durationLabel = createRefFor("durationLabel")
            val endCall = createRefFor("endCall")
            val startCall = createRefFor("startCall")

            constrain(surface) {
                customFloat("height", 48f)
                customFloat("width", 196f)
                customFloat("corner", 50f)
                customColor("color", Color.fromHex("#000000"))
            }
            constrain(avatar) {
                height = Dimension.value(38.dp)
                width = Dimension.value(38.dp)
                start.linkTo(parent.start, 8.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                alpha = 0f
            }
            constrain(nameLabel) {
                start.linkTo(avatar.end, 4.dp)
                top.linkTo(parent.top, 24.dp)
                bottom.linkTo(lastNameLabel.top)
                alpha = 0f
                scaleY = 0.5f
                scaleX = 0.5f
            }
            constrain(lastNameLabel) {
                start.linkTo(avatar.end, 4.dp)
                top.linkTo(nameLabel.bottom)
                bottom.linkTo(parent.bottom, 24.dp)
                alpha = 0f
                scaleY = 0.5f
                scaleX = 0.5f
            }
            constrain(icCall) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            constrain(icVoice) {
                end.linkTo(parent.end, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            constrain(durationLabel) {
                start.linkTo(icCall.end, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                customFloat("size", 18f)
            }
            constrain(endCall) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, 16.dp)
                alpha = 0f
                scaleY = 0f
                scaleX = 0f
            }
            constrain(startCall) {
                end.linkTo(endCall.start, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                alpha = 0f
                scaleY = 0f
                scaleX = 0f
            }
        }
        val end1 = constraintSet {
            val surface = createRefFor("surface")
            val avatar = createRefFor("avatar")
            val nameLabel = createRefFor("nameLabel")
            val lastNameLabel = createRefFor("lastNameLabel")
            val icCall = createRefFor("icCall")
            val icVoice = createRefFor("icVoice")
            val durationLabel = createRefFor("durationLabel")
            val endCall = createRefFor("endCall")
            val startCall = createRefFor("startCall")

            constrain(surface) {
                customFloat("height", 98f)
                customFloat("width", 340f)
                customFloat("corner", 10f)
                customColor("color", Color.fromHex("#4a4a4a"))
            }
            constrain(avatar) {
                height = Dimension.value(64.dp)
                width = Dimension.value(64.dp)
                start.linkTo(parent.start, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            constrain(nameLabel) {
                start.linkTo(avatar.end, 4.dp)
                top.linkTo(parent.top, 24.dp)
                bottom.linkTo(lastNameLabel.top)
                alpha = 1f
                scaleY = 1f
                scaleX = 1f
            }
            constrain(lastNameLabel) {
                start.linkTo(avatar.end, 4.dp)
                top.linkTo(nameLabel.bottom)
                bottom.linkTo(parent.bottom, 24.dp)
                alpha = 1f
                scaleY = 1f
                scaleX = 1f
            }
            constrain(icCall) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                alpha = 0f
            }
            constrain(icVoice) {
                end.linkTo(parent.end, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                alpha = 0f
            }
            constrain(durationLabel) {
                start.linkTo(icCall.end, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                alpha = 0f
            }
            constrain(endCall) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, 16.dp)
                alpha = 1f
                scaleY = 1f
                scaleX = 1f
            }
            constrain(startCall) {
                end.linkTo(endCall.start, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                alpha = 1f
                scaleY = 1f
                scaleX = 1f
            }
        }
        transition("default", start1, end1) {}
    }
}