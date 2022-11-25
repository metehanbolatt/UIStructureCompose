package com.metehanbolat.uistructurecompose.components.custom_bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: Screen("Home", "Home", Icons.Outlined.Home)
    object Search: Screen("Search", "Search", Icons.Outlined.Search)
    object Profile: Screen("Profile", "Profile", Icons.Outlined.Person)
    object Settings: Screen("Settings", "Settings", Icons.Outlined.Settings)

    object Items { val list = listOf(Home, Search, Profile, Settings) }

}
