package com.example.bloom.common.navigation

import com.example.bloom.common.Constant.wallet_route
import com.example.bloom.common.Constant.food_route
import com.example.bloom.common.Constant.home_route
import com.example.bloom.common.Constant.login_route
import com.example.bloom.common.Constant.welcome_route

sealed class Screens(val route: String) {

    object Login : Screens(login_route)
    object Welcome : Screens(welcome_route)

    object Home : Screens(home_route)
    object Food : Screens(food_route)
    object Wallet : Screens(wallet_route)
}
