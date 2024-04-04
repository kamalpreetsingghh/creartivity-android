package com.cleverlycode.creartivity.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavController,
    navbarItems: List<BottomNavItem>,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier
    ) {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        navbarItems.forEach { item ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
) {
    data object Post : BottomNavItem(
        name = "HOME",
        route = "home",
        icon = Icons.Default.Home
    )

    data object Profile : BottomNavItem(
        name = "PROFILE",
        route = "profile",
        icon = Icons.Default.Person
    )
}