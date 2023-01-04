package com.metehanbolat.uistructurecompose.components.logos

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.components.fromHex

@Composable
fun KotlinLogo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(320.dp)) {
            val bluePath = Path().apply {
                moveTo(30.dp.toPx(), 30.dp.toPx())
                lineTo(160.dp.toPx(), 30.dp.toPx())
                lineTo(30.dp.toPx(), 167.dp.toPx())
                close()
            }

            val orangePath = Path().apply {
                moveTo(30.dp.toPx(), 167.dp.toPx())
                lineTo(160.dp.toPx(), 30.dp.toPx())
                lineTo(290.dp.toPx(), 30.dp.toPx())
                lineTo(30.dp.toPx(), 290.dp.toPx())
                close()
            }

            val blueBottomPath = Path().apply {
                moveTo(30.dp.toPx(), 290.dp.toPx())
                lineTo(160.dp.toPx(), 160.dp.toPx())
                lineTo(290.dp.toPx(), 290.dp.toPx())
                close()
            }

            drawPath(
                path = bluePath,
                brush = Brush.linearGradient(
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f),
                    colors = listOf(
                        Color.fromHex("#0095D5"),
                        Color.fromHex("#3C83DC"),
                        Color.fromHex("#6D74E1"),
                        Color.fromHex("#806EE3")
                    )
                )
            )

            drawPath(
                path = orangePath,
                brush = Brush.linearGradient(
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f),
                    colors = listOf(
                        Color.fromHex("#C757BC"),
                        Color.fromHex("#D0609A"),
                        Color.fromHex("#E1725C"),
                        Color.fromHex("#EE7E2F"),
                        Color.fromHex("#F58613"),
                        Color.fromHex("#F88909")
                    )
                )
            )

            drawPath(
                path = blueBottomPath,
                brush = Brush.linearGradient(
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f),
                    colors = listOf(
                        Color.fromHex("#0095D5"),
                        Color.fromHex("#3C83DC"),
                        Color.fromHex("#6D74E1"),
                        Color.fromHex("#806EE3")
                    )
                )
            )
        }
    }
}

@Preview
@Composable
fun KotlinLogoPreview() {
    KotlinLogo()
}
