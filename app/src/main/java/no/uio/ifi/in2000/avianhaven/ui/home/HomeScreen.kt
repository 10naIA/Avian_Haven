package no.uio.ifi.in2000.avianhaven.ui.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.avianhaven.R

@Composable
fun HomeScreen(
    navController: NavController)
{
    var input by rememberSaveable { mutableStateOf("") }
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
                    painter = painterResource(id = R.drawable.outline_book_2_24),
                    contentDescription = null,
                    tint = Color.Cyan,
                )},
            onClick = {
                navController.navigate("birdLibraryScreen")
            })
            Text(
                text = "Bird library",
                modifier = Modifier
                    .align(Alignment.End)
        )

        Spacer(modifier = Modifier
            .padding(10.dp)
        )
        TextField(
            value = input,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 4.dp,
                    color = Color.Magenta
                ),
            onValueChange = {input = it},
            placeholder = { Text(text = "Type in bird name:")},
        )
    }
}