package no.uio.ifi.in2000.avianhaven.ui.library

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import no.uio.ifi.in2000.avianhaven.data.Entity
import no.uio.ifi.in2000.avianhaven.ui.theme.DarkerBlue
import no.uio.ifi.in2000.avianhaven.ui.theme.LightBlue
import no.uio.ifi.in2000.avianhaven.ui.theme.MidnightBlue
import no.uio.ifi.in2000.avianhaven.ui.theme.SkyBlue

@Composable
fun BirdLibraryScreen(
    navController: NavController,
    birdLibraryViewModel: BirdLibraryViewModel = viewModel()
) {
    //databaseTransfer.setUpDBConnection()
    val libraryUiState by birdLibraryViewModel.birdUiState.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(MidnightBlue, DarkerBlue),
                    start = Offset(0.0f, 0.0f),
                    end = Offset(0.0f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        items(libraryUiState.currentEntityList.size) {
            val item = libraryUiState.currentEntityList[it]
            BirdCard(
                entity = item,
                onClick = {
                    navController.navigate("infoscreen/${item.id}")
                }
            )
        }
    }
}

@Composable
fun BirdCard(
    entity: Entity,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .clickable(onClick = onClick)
            .graphicsLayer {
                alpha = 0.85f
            },
        colors = CardDefaults.cardColors(Transparent)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = White.copy(alpha = 0.2f)
        ) {
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
                        .clip(RoundedCornerShape(40.dp))
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp)
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Name: ${entity.name}"
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Latin name: ",
                    )
                    Text(
                        text = entity.latinName,
                        fontStyle = FontStyle.Italic
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}