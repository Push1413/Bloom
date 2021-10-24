package com.example.bloom.common.navigation

import com.example.bloom.R
import com.example.bloom.common.Constant.wallet_route
import com.example.bloom.common.Constant.food_route
import com.example.bloom.common.Constant.home_route

sealed class BottomNavigationItems(var route: String, var icon: Int, var title: String) {
    object Home : BottomNavigationItems(home_route, R.drawable.ic_home, "Home")
    object Food : BottomNavigationItems(food_route, R.drawable.ic_food, "Food")
    object Wallet : BottomNavigationItems(wallet_route, R.drawable.ic_wallet, "Wallet")
}
