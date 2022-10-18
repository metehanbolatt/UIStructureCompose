package com.metehanbolat.uistructurecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import com.metehanbolat.uistructurecompose.components.OtpView
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            UIStructureComposeTheme {
                OtpView()
            }
        }
    }
}
