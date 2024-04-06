package no.uio.ifi.in2000.avianhaven.ui.navigation

import no.uio.ifi.in2000.avianhaven.ui.home.HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.avianhaven.ui.info.InfoScreen
import no.uio.ifi.in2000.avianhaven.ui.library.BirdLibraryScreen

/*sealed class Screen(val route: String) {
    data object HomeScreen: Screen("homeScreen")
    data object BirdLibraryScreen: Screen("libraryScreen")
    data object InfoScreen: Screen("infoScreen/{sciName}")
}*/

@Composable
fun NavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "homeScreen"
    ) {
        composable("homeScreen") {
            HomeScreen(navController)
        }
        composable("birdLibraryScreen") {
            BirdLibraryScreen(navController)
        }
        composable("infoScreen/{sciName}") {backStackEntry ->
            backStackEntry.arguments?.getString("sciName")?.let {
                InfoScreen(
                    navController,
                    sciName = it
                )
            }
        }
    }
}

/*@Composable
fun NavController1() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(onLibraryClick = {
                navController.navigate("libraryscreen")
            })
        }
        composable("infoscreen") {
            InfoScreen()
            *//*backStackEntry ->
            InfoScreen(sciName = backStackEntry.arguments?.getString("sciName")*//*
            //)
        }

        composable("libraryscreen") {
            BirdLibraryScreen(onCardClick = {
                navController.navigate("infoscreen")
            })
        }
    }*/