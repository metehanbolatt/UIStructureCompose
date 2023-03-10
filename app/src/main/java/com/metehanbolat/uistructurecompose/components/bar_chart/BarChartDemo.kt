package com.metehanbolat.uistructurecompose.components.bar_chart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BarChartDemo() {

    val values = mutableListOf(50.dp, 200.dp, 160.dp, 300.dp, 120.dp, 200.dp, 140.dp)
    val labels = listOf("Sun", "Mon", "Thue", "Wed", "Thu", "Fri", "Sat")

    Column(
        modifier = Modifier.background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier.height(300.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            values.forEach { value ->
                CustomBar(
                    size = value,
                    max = values.maxOrNull()!!.value
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
    BarChartDemo()
}