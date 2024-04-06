package com.cleverlycode.creartivity.ui.screens.auth.login

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.creartivity.R
import com.cleverlycode.creartivity.data.repository.APIResponseStatus
import com.cleverlycode.creartivity.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {
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

    fun onSignInClick(navigateToHome: () -> Unit) {
        if(isValidSignInDetails()) {
            viewModelScope.launch {
                when (authRepository.login(email, password)) {
                    APIResponseStatus.NOT_FOUND -> {
                        loginUiState.value = loginUiState.value.copy(
                            isEmailError = true,
                            emailErrorMsgResId = R.string.error_email_not_found
                        )
                    }
                    APIResponseStatus.UNAUTHORIZED -> {
                        loginUiState.value = loginUiState.value.copy(
                            isEmailError = true,
                            emailErrorMsgResId = R.string.error_incorrect_credentials
                        )
                    }
                    APIResponseStatus.SUCCESS -> {
                        navigateToHome()
                    }

                    else -> {}
                }
            }
        }
    }

    private fun isValidSignInDetails(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginUiState.value = loginUiState.value.copy(
                isEmailError = true,
                emailErrorMsgResId = R.string.error_invalid_email
            )
            return false
        }
        return true
    }

    private fun enableOrDisableButton() {
        loginUiState.value =
            loginUiState.value.copy(isButtonEnabled = isButtonEnabled())
    }

    private fun isButtonEnabled() = email.isNotEmpty() && password.isNotEmpty()
}