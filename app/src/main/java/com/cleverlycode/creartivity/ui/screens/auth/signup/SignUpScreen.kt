package com.cleverlycode.creartivity.ui.screens.auth.signup

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.creartivity.Login
import com.cleverlycode.creartivity.R
import com.cleverlycode.creartivity.ui.composables.AnnotatedClickableText
import com.cleverlycode.creartivity.ui.composables.CustomButton
import com.cleverlycode.creartivity.ui.composables.InputText
import com.cleverlycode.creartivity.ui.theme.CreartivityTheme

@Composable
fun SignUpScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val signUpUiState by viewModel.signUpUiState

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Lets get you started.",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hi there, Embark on a journey of boundless creativity with AI.",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        InputText(
            value = signUpUiState.firstName,
            placeholder = stringResource(id = R.string.label_first_name),
            onValueChange = { viewModel.onFirstNameChange(newValue = it) }
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = signUpUiState.lastName,
            placeholder = stringResource(id = R.string.label_last_name),
            onValueChange = { viewModel.onLastNameChange(newValue = it) }
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = signUpUiState.userName,
            placeholder = stringResource(id = R.string.label_username),
            onValueChange = { viewModel.onUserNameChange(newValue = it) }
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = signUpUiState.email,
            placeholder = stringResource(id = R.string.label_email),
            onValueChange = { viewModel.onEmailChange(newValue = it) },
            isError = signUpUiState.isEmailError,
            errorMsgResId = signUpUiState.emailErrorMsgResId,
            keyboardType = KeyboardType.Email
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = signUpUiState.password,
            placeholder = stringResource(id = R.string.label_password),
            onValueChange = { viewModel.onPasswordChange(newValue = it) },
            isError = signUpUiState.isPasswordError,
            errorMsgResId = signUpUiState.passwordErrorMsgResId,
            keyboardType = KeyboardType.Password,
            visualTransformation = if (signUpUiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { viewModel.togglePasswordIcon() }) {
                    Icon(
                        painter = painterResource(if (signUpUiState.isPasswordVisible) R.drawable.icon_visibility else R.drawable.icon_visibility_off),
                        contentDescription = "Password Icon"
                    )
                }
            }
        )

        Spacer(Modifier.height(16.dp))

        InputText(
            value = signUpUiState.confirmPassword,
            placeholder = stringResource(id = R.string.label_confirm_password),
            onValueChange = { viewModel.onConfirmPasswordChange(newValue = it) },
            isError = signUpUiState.isConfirmPasswordError,
            errorMsgResId = signUpUiState.confirmPasswordErrorMsgResId,
            keyboardType = KeyboardType.Password,
            visualTransformation = if (signUpUiState.isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { viewModel.toggleConfirmPasswordIcon() }) {
                    Icon(
                        painter = painterResource(if (signUpUiState.isConfirmPasswordVisible) R.drawable.icon_visibility else R.drawable.icon_visibility_off),
                        contentDescription = "Password Icon"
                    )
                }
            }
        )

        Spacer(Modifier.height(20.dp))

        CustomButton(
            label = stringResource(R.string.label_create_account),
            onClick = { viewModel.onSignUpClick(navigateToLogin = { navController.navigate(Login.route) }) },
            enabled = signUpUiState.isButtonEnabled,
        )

        Spacer(modifier = Modifier.height(48.dp))

        AnnotatedClickableText(
            text = stringResource(R.string.label_sign_in_text),
            clickableText = stringResource(R.string.label_sign_in),
            onClick = { navController.navigate(Login.route) },
            tag = "URL"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    CreartivityTheme {
        SignUpScreen(
            navController = rememberNavController()
        )
    }
}