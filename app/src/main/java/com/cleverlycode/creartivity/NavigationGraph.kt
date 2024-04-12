package com.cleverlycode.creartivity

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cleverlycode.creartivity.ui.composables.BottomNavItem
import com.cleverlycode.creartivity.ui.screens.auth.login.LoginScreen
import com.cleverlycode.creartivity.ui.screens.auth.signup.SignUpScreen
import com.cleverlycode.creartivity.ui.screens.root.aistudio.AIStudioScreen
import com.cleverlycode.creartivity.ui.screens.root.home.HomeScreen
import com.cleverlycode.creartivity.ui.screens.root.profile.ProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        navigation(
            startDestination = Login.route,
            route = Auth.route
        ) {
            composable(route = Login.route) {
                LoginScreen(navController = navController)
            }

            composable(route = SignUp.route) {
                SignUpScreen(navController = navController)
            }
        }

        composable(route = Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(route = BottomNavItem.AIStudio.route) {
            AIStudioScreen(navController = navController)
        }
    }
}