package com.cleverlycode.creartivity.ui.screens.root.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cleverlycode.creartivity.ui.composables.ImageCard
import com.cleverlycode.creartivity.ui.composables.InputText

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val loginUiState by viewModel.homeUiState
    val images = viewModel.images.value

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            InputText(
                value = loginUiState.search,
                placeholder = "Search",
                onValueChange = { viewModel.onSearchChange(newValue = it) }
            )
        }

        items(images) {
            ImageCard(image = it)
        }
    }
}