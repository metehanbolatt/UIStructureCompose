package com.metehanbolat.uistructurecompose.components.logos

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MLogo() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(320.dp)
        ) {

            val firstColumnOfM = Path().apply {
                moveTo(93.dp.toPx(), 90.dp.toPx())
                lineTo(126.dp.toPx(), 90.dp.toPx())
                lineTo(126.dp.toPx(), 231.dp.toPx())
                lineTo(93.dp.toPx(), 231.dp.toPx())
                close()
            }

            val secondColumnOfM = Path().apply {
                moveTo(195.dp.toPx(), 90.dp.toPx())
                lineTo(228.dp.toPx(), 90.dp.toPx())
                lineTo(228.dp.toPx(), 231.dp.toPx())
                lineTo(195.dp.toPx(), 231.dp.toPx())
                close()
            }

            val firstLittleColumnOfM = Path().apply {
                moveTo(107.dp.toPx(), 107.dp.toPx())
                lineTo(125.dp.toPx(), 90.dp.toPx())
                lineTo(177.dp.toPx(), 141.dp.toPx())
                lineTo(160.dp.toPx(), 160.dp.toPx())
                close()
            }

            val secondLittleColumnOfM = Path().apply {
                moveTo(196.dp.toPx(), 90.dp.toPx())
                lineTo(213.dp.toPx(), 107.dp.toPx())
                lineTo(161.dp.toPx(), 159.dp.toPx())
                lineTo(143.dp.toPx(), 142.dp.toPx())
                close()
            }

            drawRect(
                color = Color.Black,
                topLeft = Offset(10.dp.toPx(), 5.dp.toPx()),
                size = Size(12.dp.toPx(), 150.dp.toPx()),
                style = Stroke(
                    width = 3.dp.toPx()
                )
            )

            drawPath(
                color = Color.Black,
                path = firstColumnOfM,
                style = Stroke(
                    width = 3.dp.toPx()
                )
            )

            drawPath(
                color = Color.Black,
                path = secondColumnOfM,
                style = Fill
            )

            drawPath(
                color = Color.Black,
                path = firstLittleColumnOfM,
                style = Fill
            )

            drawPath(
                color = Color.Black,
                path = secondLittleColumnOfM,
                style = Stroke(
                    width = 3.dp.toPx()
                )
            )

        }
    }
}

@Preview
@Composable
fun MLogoPreview() {
    MLogo()
}