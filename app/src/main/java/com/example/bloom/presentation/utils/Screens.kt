package com.example.bloom.presentation.utils

import com.example.bloom.common.Constant.home_route
import com.example.bloom.common.Constant.login_route
import com.example.bloom.common.Constant.welcome_route

sealed class Screens(val route: String) {
    object Home : Screens(home_route)
    object Login : Screens(login_route)
    object Welcome : Screens(welcome_route)
}
