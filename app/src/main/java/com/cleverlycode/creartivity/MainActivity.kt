package com.cleverlycode.creartivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cleverlycode.creartivity.ui.composables.BottomNavItem
import com.cleverlycode.creartivity.ui.composables.BottomNavigation
import com.cleverlycode.creartivity.ui.theme.CreartivityTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CreartivityTheme {
                val navController = rememberNavController()
                val currentDestination =
                    navController.currentBackStackEntryAsState().value?.destination

                val navbarItems = listOf(
                    BottomNavItem.Post,
                    BottomNavItem.AIStudio,
                    BottomNavItem.Profile
                )

                Scaffold(
                    bottomBar = {
                        if (currentDestination != null) {
                            if (currentDestination.route == "home" || currentDestination.route == "profile" || currentDestination.route == "aistudio") {
                                BottomNavigation(
                                    navbarItems = navbarItems,
                                    navController = navController
                                )
                            }
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph(
                        navController = navController,
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CreartivityTheme {
        NavigationGraph(
            navController = rememberNavController(),
            modifier = Modifier.padding(0.dp)
        )
    }
}