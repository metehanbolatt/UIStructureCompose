package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import com.metehanbolat.uistructurecompose.components.rainbowcircle.RainbowCircle
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIStructureComposeTheme {

                RainbowCircle(R.drawable.lion)
            }
        }
    }
}

@Composable
fun CustomTextField(
    myText: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = myText,
        onValueChange = onValueChanged,
        enabled = myText.length != 9
    )
}

