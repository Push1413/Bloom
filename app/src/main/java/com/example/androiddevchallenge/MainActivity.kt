package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screens.HomeScreen
import com.example.androiddevchallenge.screens.LoginScreen
import com.example.androiddevchallenge.screens.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                val navController = rememberNavController()
                NavHost(navController,"welcome"){
                    composable("welcome") {
                        WelcomeScreen(navController)
                    }
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("home"){
                        HomeScreen(navController)
                    }
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    WelcomeScreen(rememberNavController())
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
