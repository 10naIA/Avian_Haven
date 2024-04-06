package no.uio.ifi.in2000.avianhaven.ui.library

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
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
        item {
            val context = LocalContext.current
            val mediaPlayer = MediaPlayer.create(context, R.raw.xl143610_black_bellied_whistling_duck_dendrocygna_autumnalis)
            Button(
                onClick = {mediaPlayer.start()}
            ) {
                Text(text = "Chirp")
            }
        }
        items(libraryUiState.currentEntityList.size) {
            val item = libraryUiState.currentEntityList[it]
            BirdCard(
                entity = item,
                onClick = {
                    birdInfoViewModel.updateChosenBird(item.latinName)
                    navController.navigate("infoscreen/${item.latinName}")
                }
            )
        }
    }
}

fun playSound(context: Context) {
    val mediaPlayer = MediaPlayer.create(
        context,
        R.raw.xl143610_black_bellied_whistling_duck_dendrocygna_autumnalis
    )
    mediaPlayer.start()
}

@Composable
fun BirdCard(
    entity: Entity,
    onClick: () -> Unit,
) {
    val cardColor = colorResource(id = R.color.light_blue)

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
                text = "Latin name: ${entity.latinName}"
            )
            Text(text = "id: ${entity.id}")
            Spacer(
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}