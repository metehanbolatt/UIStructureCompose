package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.components.HexagonSection
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            UIStructureComposeTheme {

                var isScanning by remember { mutableStateOf(false) }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    HexagonSection(
                        isScanning = isScanning,
                        onScanButtonClick = { isScanning = !isScanning },
                        color = Color.Blue,
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth(0.5f)
                            .aspectRatio(6 / 7f)
                    )
                }
            }
        }
    }
}
