package com.example.bloom.common.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.bloom.common.Constant
import com.example.bloom.common.navigation.Screens
import com.example.bloom.presentation.ui.activities.auth.LoginScreen
import com.example.bloom.presentation.ui.activities.auth.WelcomeScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screens.Welcome.route,
        route = Constant.auth_route
    ) {
        composable(
            route = Screens.Welcome.route
        ) {
            WelcomeScreen(navController = navController)
        }

        composable(
            route = Screens.Login.route
        ) {
            LoginScreen(navController = navController)
        }
    }
}