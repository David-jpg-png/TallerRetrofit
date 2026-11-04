package dev.archfoundry.marsphotosapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.archfoundry.marsphotosapp.ui.screen.HomeScreen
import dev.archfoundry.marsphotosapp.ui.screen.MarsViewModel

@Composable
fun MarsPhotosApp() {
    val viewModel: MarsViewModel = viewModel()
    Scaffold() { innerPadding ->
        HomeScreen(
            marsUiState = viewModel.marsUiState,
            modifier = Modifier.padding(innerPadding)
        )
    }
}