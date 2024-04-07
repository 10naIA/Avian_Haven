package no.uio.ifi.in2000.avianhaven.ui.info

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import no.uio.ifi.in2000.avianhaven.R
import no.uio.ifi.in2000.avianhaven.ui.theme.DarkerBlue
import no.uio.ifi.in2000.avianhaven.ui.theme.MidnightBlue

@Composable
fun InfoScreen(
    navController: NavController,
    id: Int,
    birdInfoViewModel: InfoViewModel = viewModel(),
    ) {
    birdInfoViewModel.updateChosenBird(id)
    val birdPageUiState by birdInfoViewModel.infoUiState.collectAsState()

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
        item {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .graphicsLayer {
                        alpha = 0.85f
                    },
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                AsyncImage(
                    model = birdPageUiState.currentEntity?.images?.get(0),
                    contentDescription = "Bird picture",
                    modifier = Modifier
                        .size(400.dp)
                        .padding(10.dp)
                )
                val audioURL = birdPageUiState.sound
                val mediaPlayer = MediaPlayer()
                try {
                    val audioAttributes = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                    mediaPlayer.setAudioAttributes(audioAttributes)
                    mediaPlayer.setDataSource(audioURL)
                    mediaPlayer.prepare()
                }
                catch(e: Exception) {
                    e.printStackTrace()
                }
                if(audioURL != null) {
                    IconButton(
                        onClick = { mediaPlayer.start() },
                        modifier = Modifier
                            .align(Alignment.End),
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_music_note_24),
                                contentDescription = "Music note",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(43.dp)
                            )
                        }
                    )
                }
                Text(text = "Name: ${birdPageUiState.currentEntity?.name}")
                Row {
                    Text(text = "Latin name: ")
                    Text(
                        text = "${birdPageUiState.currentEntity?.latinName}",
                        fontStyle = FontStyle.Italic
                    )
                }
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
}