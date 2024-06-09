package com.carlosprieto.wordline.navigation

sealed class Screen(val route: String) {
    object StadiumListScreen : Screen("main_screen")
    object StadiumDetailsScreen : Screen("details_screen")
}
