package com.cleverlycode.creartivity

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cleverlycode.creartivity.ui.screens.auth.login.LoginScreen
import com.cleverlycode.creartivity.ui.screens.auth.signup.SignUpScreen
import com.cleverlycode.creartivity.ui.screens.root.home.HomeScreen
import com.cleverlycode.creartivity.ui.screens.root.profile.ProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "SignUp") {
        composable(SignUp.route) {
            SignUpScreen(navController = navController)
        }

        composable(Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}