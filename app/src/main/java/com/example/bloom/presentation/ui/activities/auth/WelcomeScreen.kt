package com.example.bloom.presentation.ui.activities.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bloom.R
import com.example.bloom.common.Constant.login_route
import com.example.bloom.presentation.ui.theme.MyTheme
import com.example.bloom.presentation.ui.theme.Pink900
import com.example.bloom.presentation.ui.theme.White
import com.example.bloom.presentation.utils.BloomSecondaryButton

@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
    ) {
        WelcomeBackground()

        WelcomeScreenContent(navController)
    }
}

@Composable
private fun WelcomeScreenContent(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(72.dp))

        LeafImage()

        Spacer(Modifier.height(48.dp))

        LogoImage()

        AppSubtitle()

        Spacer(Modifier.height(40.dp))

        CreateAccountButton(navController)

        Spacer(Modifier.height(8.dp))

        LoginButton(navController)


    }

}

@Composable
 private fun LoginButton(navController: NavController) {
    val isLight = MaterialTheme.colors.isLight

    val textColor = if (isLight) {
        Pink900
    } else {
        White
    }

    TextButton(
        onClick = {
                  navController.navigate(login_route)
        },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "Log in",
            color = textColor,
        )
    }
}

@Composable
fun CreateAccountButton(navController: NavController) {
    BloomSecondaryButton(buttonText ="Create account",
    nav =navController,
    destination = login_route)
}

@Composable
fun AppSubtitle() {
    Text(
        text = "Beautiful home garden solutions",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
    )
}

@Composable
fun LogoImage() {
    val isLight = MaterialTheme.colors.isLight

    val logoImageRes = if (isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }

    Image(
        painter = painterResource(id = logoImageRes),
        contentDescription = "Bloom",
    )
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

@Preview()
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(rememberNavController())
    }
}
