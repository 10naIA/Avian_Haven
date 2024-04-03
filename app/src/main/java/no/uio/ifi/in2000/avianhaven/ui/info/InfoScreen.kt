package no.uio.ifi.in2000.avianhaven.ui.info

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun InfoScreen(
    navController: NavController,
    sciName: String?,
    birdInfoViewModel: InfoViewModel = viewModel(),
    ) {
    val birdPageUiState by birdInfoViewModel.infoUiState.collectAsState()

    Column {
        AsyncImage(
            model = birdPageUiState.currentEntity?.images?.get(0),
            contentDescription = "Bird picture",
        )
        Text(text = "Name: ${birdPageUiState.currentEntity?.name}")
        Text(text = "Latin name: ${birdPageUiState.currentEntity?.latinName}")
        Text(text = "Family: ${birdPageUiState.currentEntity?.family}")
        Text(text = "Features(Colors, size..:)")
        Text(text = "Behaviour(funfacts: )")
        Text(text = "Life expectancy: ")
        Text(text = "Fly south?: ")
        Text(text = "Food: ")
        Text(text = "Nesting time: ")
    }
}