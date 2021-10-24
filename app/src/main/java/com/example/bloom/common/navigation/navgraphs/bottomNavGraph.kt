package com.example.bloom.common.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.bloom.common.Constant
import com.example.bloom.common.navigation.Screens
import com.example.bloom.presentation.ui.activities.CoinScreen
import com.example.bloom.presentation.ui.activities.FoodScreen
import com.example.bloom.presentation.ui.activities.HomeScreen

fun NavGraphBuilder.bottomNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screens.Home.route,
        route = Constant.main_route
    ) {
        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screens.Food.route
        ) {
            FoodScreen(navController = navController)
        }

        composable(
            route = Screens.Wallet.route
        ) {
            CoinScreen(navController = navController)
        }
    }
}