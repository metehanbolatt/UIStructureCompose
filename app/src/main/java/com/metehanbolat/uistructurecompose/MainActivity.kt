package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.metehanbolat.uistructurecompose.components.custom_bottom_navigation.CustomBottomNavigation
import com.metehanbolat.uistructurecompose.components.custom_bottom_navigation.Screen
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            UIStructureComposeTheme {

                val currentScreen = remember { mutableStateOf<Screen>(Screen.Home) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        bottomBar = {
                            CustomBottomNavigation(currentScreenId = currentScreen.value.id) {
                                currentScreen.value = it
                            }
                        }
                    ) { paddingValues ->
                        Box(modifier = Modifier.padding(paddingValues))
                    }
                }
            }
        }
    }
}


