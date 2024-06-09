package com.carlosprieto.wordline.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carlosprieto.wordline.presentation.details.StadiumDetailsScreen
import com.carlosprieto.wordline.presentation.list.StadiumListScreen


@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.StadiumListScreen.route
    ) {
        composable(
            route = Screen.StadiumListScreen.route
        ) {
            StadiumListScreen(navController)
        }
        composable(
            route = Screen.StadiumDetailsScreen.route + "/{stadiumId}"
        ) {
            StadiumDetailsScreen(navController)
        }
    }
}
