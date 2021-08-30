package com.example.androiddevchallenge.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen(navController: NavController){


}

@Preview()
@Composable
private fun LoginScreenPreview() {
    MyTheme(darkTheme = false) {
        HomeScreen(rememberNavController())
    }
}