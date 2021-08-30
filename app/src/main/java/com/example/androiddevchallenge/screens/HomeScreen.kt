package com.example.androiddevchallenge.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.defaultPlantThemes
import com.example.androiddevchallenge.recyclerview.ItemPlantTheme
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen(navController: NavController) {

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Spacer(modifier = Modifier.height(40.dp))

            SearchInput()

            BrowseThemeSection()

        }
    }

}

@Composable
private fun BrowseThemeSection() {
    Text(
        text = "Browse Themes",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
            .padding(horizontal = 16.dp)
    )
    
    Spacer(modifier = Modifier.height(16.dp))
    
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        defaultPlantThemes.forEach { theme ->
            ItemPlantTheme(plantTheme = theme)
        }
    }
}

@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        label = {
            Text(text = "Search")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview()
@Composable
private fun HomeScreenPreview() {
    MyTheme(darkTheme = false) {
        HomeScreen(rememberNavController())
    }
}