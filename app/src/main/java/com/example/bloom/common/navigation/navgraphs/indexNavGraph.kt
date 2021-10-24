package com.example.bloom.common.navigation.navgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.bloom.common.Constant

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Constant.auth_route,
        route = Constant.index_route
    ) {

        authNavGraph(navController = navHostController)

        bottomNavGraph(navController = navHostController)

    }
}