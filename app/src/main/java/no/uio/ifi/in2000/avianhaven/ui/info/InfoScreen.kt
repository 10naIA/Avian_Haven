package no.uio.ifi.in2000.avianhaven.ui.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun InfoScreen(
    navController: NavController,
    sciName: String,
    birdInfoViewModel: InfoViewModel = viewModel(),
    ) {
    birdInfoViewModel.updateChosenBird(sciName)
    val birdPageUiState by birdInfoViewModel.infoUiState.collectAsState()

    LazyColumn {
        item {
            AsyncImage(
                model = birdPageUiState.currentEntity?.images?.get(0),
                contentDescription = "Bird picture",
                modifier = Modifier
                    .size(400.dp)
                    .padding(10.dp)
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
}