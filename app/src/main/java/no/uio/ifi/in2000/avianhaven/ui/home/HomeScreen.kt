package no.uio.ifi.in2000.avianhaven.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.avianhaven.R
import no.uio.ifi.in2000.avianhaven.ui.theme.DarkerBlue
import no.uio.ifi.in2000.avianhaven.ui.theme.MidnightBlue

@Composable
fun HomeScreen(
    navController: NavController)
{
    var input by rememberSaveable { mutableStateOf("") }
    Column(
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
        //Ny
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .size(50.dp),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.round_cloud_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(48.dp)
                    )
                },
                onClick = {
                    navController.navigate("birdLibraryScreen")
                })
/*            Text(
                text = "Bird library",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.End)
            )*/

            Spacer(
                modifier = Modifier
                    .padding(10.dp)
            )
            TextField(
                value = input,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .graphicsLayer {
                        alpha = 0.85f
                    },
                onValueChange = { input = it },
                placeholder = { Text(text = "Type in bird name:") },
            )
        }
    }
}