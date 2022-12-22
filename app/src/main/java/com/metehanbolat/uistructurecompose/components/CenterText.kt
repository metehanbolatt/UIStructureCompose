package com.metehanbolat.uistructurecompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CenterText() {
    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(
                MaterialTheme.colors.primary,
                shape = RoundedCornerShape(8.dp)
            )
            .height(56.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable { },
        textAlign = TextAlign.Center,
        text = "Metehan"
    )
}

@Preview(showBackground = true)
@Composable
fun CenterTextPreview() {
    CenterText()
}