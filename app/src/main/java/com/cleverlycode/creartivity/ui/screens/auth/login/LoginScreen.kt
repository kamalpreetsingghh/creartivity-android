package com.cleverlycode.creartivity.ui.screens.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cleverlycode.creartivity.Home
import com.cleverlycode.creartivity.R
import com.cleverlycode.creartivity.SignUp
import com.cleverlycode.creartivity.ui.composables.AnnotatedClickableText
import com.cleverlycode.creartivity.ui.composables.CustomButton
import com.cleverlycode.creartivity.ui.composables.InputText

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val loginUiState by viewModel.loginUiState

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Lets Sign you in",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Welcome back,",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "you have been missed",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        InputText(
            value = loginUiState.email,
            placeholder = stringResource(id = R.string.label_email),
            onValueChange = { viewModel.onEmailChange(newValue = it) },
            isError = loginUiState.isEmailError,
            errorMsgResId = loginUiState.emailErrorMsgResId,
            keyboardType = KeyboardType.Email
        )

        Spacer(Modifier.height(12.dp))

        InputText(
            value = loginUiState.password,
            placeholder = stringResource(id = R.string.label_password),
            onValueChange = { viewModel.onPasswordChange(newValue = it) },
            isError = loginUiState.isPasswordError,
            errorMsgResId = loginUiState.passwordErrorMsgResId,
            keyboardType = KeyboardType.Password,
            visualTransformation = if (loginUiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { viewModel.togglePasswordIcon() }) {
                    Icon(
                        painter = painterResource(if (loginUiState.isPasswordVisible) R.drawable.icon_visibility else R.drawable.icon_visibility_off),
                        contentDescription = "Password Icon"
                    )
                }
            }
        )

        Spacer(Modifier.height(16.dp))

        CustomButton(
            label = stringResource(R.string.label_sign_in),
            onClick = { viewModel.onSignInClick(navigateToHome = { navController.navigate(Home.route) }) },
            enabled = loginUiState.isButtonEnabled
        )

        Spacer(modifier = Modifier.height(48.dp))

        AnnotatedClickableText(
            text = stringResource(R.string.label_sign_up_text),
            clickableText = stringResource(R.string.label_sign_up),
            onClick = { navController.navigate(SignUp.route) },
            tag = "URL"
        )
    }
}