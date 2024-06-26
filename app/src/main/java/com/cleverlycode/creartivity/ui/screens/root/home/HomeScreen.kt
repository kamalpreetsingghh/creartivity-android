package com.cleverlycode.creartivity.ui.screens.root.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cleverlycode.creartivity.R
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

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        InputText(
            value = loginUiState.search,
            placeholder = "Search",
            onValueChange = { viewModel.onSearchChange(newValue = it) },
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = "Password Icon"
                )
            }
        )

        Surface(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn {
                items(images) {
                    ImageCard(
                        image = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
                    )
                }
            }
        }
    }
}