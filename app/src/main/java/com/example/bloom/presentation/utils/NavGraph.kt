package com.example.bloom.presentation.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bloom.presentation.ui.activities.HomeScreen
import com.example.bloom.presentation.ui.activities.LoginScreen
import com.example.bloom.presentation.ui.activities.WelcomeScreen

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Welcome.route
    ) {
        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(navController = navHostController)
        }
        composable(
            route = Screens.Login.route
        ) {
            LoginScreen(navController = navHostController)
        }
        composable(
            route = Screens.Welcome.route
        ) {
            WelcomeScreen(navController = navHostController)
        }
    }
}