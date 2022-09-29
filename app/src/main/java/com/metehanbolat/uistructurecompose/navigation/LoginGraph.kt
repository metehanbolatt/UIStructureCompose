package com.metehanbolat.uistructurecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.metehanbolat.uistructurecompose.login.LoginPage
import com.metehanbolat.uistructurecompose.login.RegisterPage

@Composable
fun LoginApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = GraphScreens.LOGIN.pageName, builder = {
        composable(GraphScreens.LOGIN.pageName, content = { LoginPage(navController = navController) })
        composable(GraphScreens.REGISTER.pageName, content = { RegisterPage(navController = navController) })
    })
}

enum class GraphScreens(val pageName: String) {
    LOGIN("login_page"),
    REGISTER("register_page")
}