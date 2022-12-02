package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIStructureComposeTheme {

                var myText by remember { mutableStateOf("") }
                var myText2 by remember { mutableStateOf("") }

                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomTextField(myText) {
                            myText = it
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        CustomTextField(myText2) {
                            myText2 = it
                        }
                    }
                }
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

