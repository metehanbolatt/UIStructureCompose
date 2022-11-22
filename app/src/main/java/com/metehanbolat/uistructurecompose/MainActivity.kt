package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            UIStructureComposeTheme {
                MyComposable()
            }
        }
    }
}


@Composable
fun MyComposable() {

    var myValue by remember { mutableStateOf(false) }
    println("First")

    Button(
        onClick = {
            myValue = !myValue
        }
    ) {
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
        Text(text = "$myValue")
        println("Second")
    }

    Text(text = "Metehan")
    println("Third")

}

