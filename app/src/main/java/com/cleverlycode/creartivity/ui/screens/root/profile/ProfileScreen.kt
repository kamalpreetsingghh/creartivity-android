package com.cleverlycode.creartivity.ui.screens.root.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cleverlycode.creartivity.Login
import com.cleverlycode.creartivity.R
import com.cleverlycode.creartivity.ui.composables.CustomButton

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (viewModel.isUserLoggedIn.value) {
            Text(
                text = "My Profile",
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomButton(
                label = stringResource(R.string.label_logout_text),
                onClick = { viewModel.onLogoutClick { navController.navigate(Login.route) } }
            )
        } else {
            CustomButton(
                label = stringResource(R.string.label_sign_in),
                onClick = { viewModel.onLoginClick { navController.navigate(Login.route) } }
            )

            CustomButton(
                label = stringResource(R.string.label_sign_up),
                onClick = { viewModel.onLoginClick { navController.navigate(Login.route) } }
            )
        }
    }
}