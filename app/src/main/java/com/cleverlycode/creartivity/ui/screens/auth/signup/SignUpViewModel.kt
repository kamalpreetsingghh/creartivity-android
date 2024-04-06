package com.cleverlycode.creartivity.ui.screens.auth.signup

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.creartivity.R
import com.cleverlycode.creartivity.data.repository.APIResponseStatus
import com.cleverlycode.creartivity.data.repository.AuthRepository
import com.cleverlycode.creartivity.domain.models.SignUp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {
    var signUpUiState = mutableStateOf(SignUpUiState())
        private set

    private val firstName get() = signUpUiState.value.firstName
    private val lastName get() = signUpUiState.value.lastName
    private val userName get() = signUpUiState.value.userName
    private val email get() = signUpUiState.value.email
    private val password get() = signUpUiState.value.password
    private val confirmPassword get() = signUpUiState.value.confirmPassword

    fun onFirstNameChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(firstName = newValue)
        enableOrDisableButton()
    }

    fun onLastNameChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(lastName = newValue)
        enableOrDisableButton()
    }

    fun onUserNameChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(userName = newValue)
        enableOrDisableButton()
    }

    fun onEmailChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(email = newValue)
        signUpUiState.value = signUpUiState.value.copy(
            isEmailError = false,
            emailErrorMsgResId = null
        )
        enableOrDisableButton()
    }

    fun onPasswordChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(password = newValue)
        signUpUiState.value = signUpUiState.value.copy(
            isPasswordError = false,
            passwordErrorMsgResId = null
        )
        enableOrDisableButton()
    }

    fun onConfirmPasswordChange(newValue: String) {
        signUpUiState.value = signUpUiState.value.copy(confirmPassword = newValue)
        signUpUiState.value = signUpUiState.value.copy(
            isConfirmPasswordError = false,
            confirmPasswordErrorMsgResId = null
        )
        enableOrDisableButton()
    }

    fun onSignUpClick(navigateToLogin: () -> Unit) {
        if (isValidSignUpDetails()) {
            viewModelScope.launch {
                val response = authRepository.signup(
                    SignUp(
                        firstName = firstName,
                        lastName = lastName,
                        userName = userName,
                        email = email,
                        password = password
                    )
                )

                if (response == APIResponseStatus.SUCCESS) {
                    navigateToLogin()
                } else {

                }
            }
        }
    }

    private fun isValidSignUpDetails(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpUiState.value = signUpUiState.value.copy(
                isEmailError = true,
                emailErrorMsgResId = R.string.error_invalid_email
            )
            return false
        }

        if (!doPasswordsMatch()) {
            signUpUiState.value = signUpUiState.value.copy(
                isConfirmPasswordError = true,
                confirmPasswordErrorMsgResId = R.string.error_confirm_password
            )
            return false
        }

        return true
    }

    private fun enableOrDisableButton() {
        signUpUiState.value =
            signUpUiState.value.copy(isButtonEnabled = isButtonEnabled())
    }

    private fun isButtonEnabled() = firstName.isNotEmpty() && lastName.isNotEmpty()
            && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()

    fun togglePasswordIcon() {
        signUpUiState.value =
            signUpUiState.value.copy(isPasswordVisible = !signUpUiState.value.isPasswordVisible)
    }

    fun toggleConfirmPasswordIcon() {
        signUpUiState.value =
            signUpUiState.value.copy(isConfirmPasswordVisible = !signUpUiState.value.isConfirmPasswordVisible)
    }

    private fun doPasswordsMatch() = password == confirmPassword
}