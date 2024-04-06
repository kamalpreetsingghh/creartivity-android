package com.cleverlycode.creartivity.ui.screens.root.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cleverlycode.creartivity.Login
import com.cleverlycode.creartivity.ui.composables.CustomButton

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (viewModel.isUserLoggedIn.value) {
            CustomButton(
                label = "Logout",
                onClick = { viewModel.onLogoutClick { navController.navigate(Login.route) } }
            )
        } else {
            CustomButton(
                label = "Login",
                onClick = { viewModel.onLoginClick { navController.navigate(Login.route) } }
            )
        }
    }
}