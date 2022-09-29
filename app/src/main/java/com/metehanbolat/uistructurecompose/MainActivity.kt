package com.metehanbolat.uistructurecompose

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.metehanbolat.uistructurecompose.login.LoginPage
import com.metehanbolat.uistructurecompose.login.RegisterPage
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIStructureComposeTheme {
                RegisterPage()
            }
        }
    }
}
