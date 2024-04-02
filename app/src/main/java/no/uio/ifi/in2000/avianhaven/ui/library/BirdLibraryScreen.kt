package no.uio.ifi.in2000.avianhaven.ui.library

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import no.uio.ifi.in2000.avianhaven.R
import no.uio.ifi.in2000.avianhaven.data.Entity
import no.uio.ifi.in2000.avianhaven.ui.info.InfoViewModel

@Composable
fun BirdLibraryScreen(
    navController: NavController,
    birdInfoViewModel: InfoViewModel = viewModel(),
    birdLibraryViewModel: BirdLibraryViewModel = viewModel()
) {
    //databaseTransfer.setUpDBConnection()
    val libraryUiState by birdLibraryViewModel.birdUiState.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(libraryUiState.currentBirdList.size) {
            val item = libraryUiState.currentBirdList[it]
            BirdCard(
                entity = item,
                onClick = {
                    birdInfoViewModel.updateChosenBird(item.sciName)
                    navController.navigate("infoscreen/${item.sciName}")
                }
            )
        }
    }
}

@Composable
fun BirdCard(
    entity: Entity,
    onClick: () -> Unit,
    birdLibraryViewModel: BirdLibraryViewModel = viewModel()

) {
    val cardColor = colorResource(id = R.color.light_blue)
    val libraryUiState by birdLibraryViewModel.birdUiState.collectAsState()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(cardColor)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = entity.images[0],
                contentDescription = null,
                // Brukes for aa faa bildet helt rundt, ble ellers kantete
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CutCornerShape(10.dp))
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "Name: ${entity.name}"
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "Latin name: ${entity.sciName}"
            )
            Spacer(
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}