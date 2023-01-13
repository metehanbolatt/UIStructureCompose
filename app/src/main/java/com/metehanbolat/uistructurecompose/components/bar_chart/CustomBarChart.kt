package com.metehanbolat.uistructurecompose.components.bar_chart

import android.widget.Toast
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomBarChart() {

    val values = mutableListOf(50.dp, 200.dp, 160.dp, 300.dp, 120.dp, 200.dp, 140.dp)
    val labels = listOf("Mon", "Sun", "Thue", "Wed", "Thu", "Fri", "Sat")
    val context = LocalContext.current

    var heightState by remember { mutableStateOf(0.dp) }
    val heightAnimate by animateDpAsState(
        targetValue = heightState,
        tween(
            durationMillis = 3000,
            delayMillis = 300,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier.background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier.height(300.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            values.forEach { value ->
                LaunchedEffect(key1 = value) {
                    heightState = value
                    println(heightState)
                }
                //println(heightState)
                Box(
                    modifier = Modifier
                        .padding(start = 4.dp, bottom = 0.dp, end = 4.dp, top = 10.dp)
                        .weight(1f)
                        .size(heightAnimate)
                        .border(BorderStroke(1.dp, Color.Black))
                        .background(Color.Red.copy(alpha = heightAnimate.value / values.max().value))
                        .clickable(role = Role.Button, onClickLabel = "Graphic Item") {
                            Toast
                                .makeText(context, "Value: $heightAnimate", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            labels.forEach { label ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .width(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = label
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CustomBarChartPreview() {
    CustomBarChart()
}