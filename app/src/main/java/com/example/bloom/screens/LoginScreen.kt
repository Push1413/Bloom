package com.example.bloom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bloom.ui.theme.MyTheme
import com.example.bloom.utils.BloomSecondaryButton

@Composable
fun LoginScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            LogInHeader()

            EmailInput()

            Spacer(Modifier.height(8.dp))

            PasswordInput()

            TermsOfServiceLabel()

            Spacer(Modifier.height(16.dp))

            LoginButton(navController)
        }
    }
}

@Composable
private fun LoginButton(navController: NavController) {
    BloomSecondaryButton(
        buttonText = "Log in",
        nav = navController,
        destination = "home"
    )
}

@Composable
private fun TermsOfServiceLabel() {
    Text(
        text = "By clicking below you agree to our Terms of Use and consent to our Privacy Policy.",
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .paddingFromBaseline(top = 24.dp),
    )
}

@Composable
private fun PasswordInput() {
    val passState = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = passState.value,
        onValueChange = { newState ->
            passState.value = newState
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation(),
        label = {
            Text(text = "Password (8 + characters)")
        },
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
private fun EmailInput() {
    // [rememberSaveable] for config change handling
    val emailState = rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = emailState.value,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        onValueChange = {
            emailState.value = it
        },
        label = {
            Text(text = "Email Address")
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun LogInHeader() {
    Text(
        text = "Login with Email",
        style = MaterialTheme.typography.h1,
        modifier = Modifier.paddingFromBaseline(
            top = 184.dp,
            bottom = 16.dp
        )
    )
}

@Preview()
@Composable
private fun LoginScreenPreview() {
    MyTheme(darkTheme = false) {
        LoginScreen(rememberNavController())
    }
}
