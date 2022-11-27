package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.metehanbolat.uistructurecompose.components.SwipeRefreshLazy
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            UIStructureComposeTheme {
                SwipeRefreshLazy()
            }
        }
    }
}


