package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import com.metehanbolat.uistructurecompose.components.CustomBarChart
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            UIStructureComposeTheme {
                val data = mapOf(
                    Pair(0.3f, 11),
                    Pair(0.6f, 13),
                    Pair(0.2f, 16),
                    Pair(0.7f, 18),
                    Pair(0.4f, 19),
                )
                CustomBarChart(data = data, maxValue = 1000)
            }
        }
    }
}
