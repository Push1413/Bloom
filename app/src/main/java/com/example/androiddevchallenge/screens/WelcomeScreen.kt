package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen() {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
    ) {
        WelcomeBackground()

        WelcomeScreenContent()
    }
}

@Composable
private fun WelcomeScreenContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier =Modifier.height(72.dp))

        LeafImage()
    }

}

@Composable
private fun LeafImage() {
    val isLight = MaterialTheme.colors.isLight

    val leafImageRes = if (isLight) {
        R.drawable.ic_light_welcome_illos
    } else {
        R.drawable.ic_dark_welcome_illos
    }

    Image(
        painter = painterResource(id = leafImageRes),
        contentDescription = null,
        modifier = Modifier
            .offset(x = 88.dp)
    )
}

@Composable
private fun WelcomeBackground() {
    val isLight = MaterialTheme.colors.isLight
    val backgroundImageRes = if (isLight) {
        R.drawable.ic_light_welcome_bg
    } else {
        R.drawable.ic_dark_welcome_bg
    }

    Image(
        painterResource(id = backgroundImageRes),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Preview("Dark Theme")
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen()
    }
}
