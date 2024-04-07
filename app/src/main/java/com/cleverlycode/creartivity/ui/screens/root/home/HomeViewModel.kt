package com.cleverlycode.creartivity.ui.screens.root.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.creartivity.data.models.ImageId
import com.cleverlycode.creartivity.data.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    ViewModel() {
    var homeUiState = mutableStateOf(HomeUiState())
        private set

    var images = mutableStateOf(emptyList<ImageId>())

    private var dataFetched = false
    private var searchJob: Job? = null

    init {
        if (!dataFetched) {
            getImages()
            dataFetched = true
        }
    }

    fun onSearchChange(newValue: String) {
        homeUiState.value = homeUiState.value.copy(search = newValue)
        search(query = newValue)
    }

    private fun getImages() {
        viewModelScope.launch(Dispatchers.IO) {
            images.value = imageRepository.getImages()
        }
    }

    private fun search(query: String) {
        searchJob?.cancel()

        searchJob = viewModelScope.launch {
            delay(1000)
            images.value = imageRepository.getImages(searchQuery = query)
        }
    }

}