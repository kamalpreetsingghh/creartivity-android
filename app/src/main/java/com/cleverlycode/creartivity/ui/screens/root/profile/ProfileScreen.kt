package com.cleverlycode.creartivity.ui.screens.root.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cleverlycode.creartivity.Login
import com.cleverlycode.creartivity.ui.composables.CustomButton

@Composable
fun ProfileScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        CustomButton(
            label = "Login",
            onClick = {navController.navigate(Login.route)}
        )
    }
}