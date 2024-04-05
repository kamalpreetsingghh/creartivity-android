package com.cleverlycode.creartivity.ui.screens.auth.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var loginUiState = mutableStateOf(LoginUiState())
        private set

    private val email get() = loginUiState.value.email
    private val password get() = loginUiState.value.password

    fun onEmailChange(newValue: String) {
        loginUiState.value = loginUiState.value.copy(email = newValue)
        enableOrDisableButton()
        loginUiState.value = loginUiState.value.copy(
            isEmailError = false,
            emailErrorMsgResId = null
        )
    }

    fun onPasswordChange(newValue: String) {
        loginUiState.value = loginUiState.value.copy(password = newValue)
        enableOrDisableButton()
        loginUiState.value = loginUiState.value.copy(
            isPasswordError = false,
            passwordErrorMsgResId = null
        )
    }

    fun togglePasswordIcon() {
        loginUiState.value =
            loginUiState.value.copy(isPasswordVisible = !loginUiState.value.isPasswordVisible)
    }

    fun onSignInClick() {

    }

    private fun enableOrDisableButton() {
        loginUiState.value =
            loginUiState.value.copy(isButtonEnabled = isButtonEnabled())
    }

    private fun isButtonEnabled() = email.isNotEmpty() && password.isNotEmpty()
}