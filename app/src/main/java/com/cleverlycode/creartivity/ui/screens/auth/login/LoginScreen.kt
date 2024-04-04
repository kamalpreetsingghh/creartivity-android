package com.cleverlycode.creartivity.ui.screens.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cleverlycode.creartivity.Home
import com.cleverlycode.creartivity.SignUp

@Composable
fun LoginScreen(navController: NavController) {
    Column {
        Text(text = "Login")
        Text(
            text = "Don't have an account? Register Now",
            modifier = Modifier.clickable {  navController.navigate(SignUp.route) }
        )

        Text(
            text = "Home",
            modifier = Modifier.clickable {  navController.navigate(Home.route) }
        )
    }
}