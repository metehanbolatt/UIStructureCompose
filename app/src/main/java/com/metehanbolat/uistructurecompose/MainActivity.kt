package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.components.tiltOnTouch
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            UIStructureComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .size(width = 400.dp, height = 300.dp)
                                .tiltOnTouch(),
                            painter = painterResource(id = R.drawable.sekerbank_kredi_kart),
                            contentDescription = null
                        )
                    }
                }
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

