package com.cleverlycode.creartivity.ui.screens.root.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.creartivity.data.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    ViewModel() {
    init {
        viewModelScope.launch {
            imageRepository.getImages()
        }
    }
}