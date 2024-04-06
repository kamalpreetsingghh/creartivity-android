package com.cleverlycode.creartivity.ui.screens.root.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.creartivity.data.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userPreferencesRepository: UserPreferencesRepository) :
    ViewModel() {
    var profileUiState = mutableStateOf(ProfileUiState())
        private set

    val isUserLoggedIn = mutableStateOf(false)

    init {
        viewModelScope.launch {
            userPreferencesRepository.isUserSignedIn.collect {
                isUserLoggedIn.value = it
            }
        }
    }

    fun onLoginClick(navigateToLogin: () -> Unit) {
        navigateToLogin()
    }

    fun onLogoutClick(navigateToLogin: () -> Unit) {
        viewModelScope.launch {
            userPreferencesRepository.clearDataStore()
        }

        navigateToLogin()
    }
}