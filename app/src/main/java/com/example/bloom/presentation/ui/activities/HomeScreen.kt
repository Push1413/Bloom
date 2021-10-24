package com.example.bloom.presentation.ui.activities

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bloom.data.defaultPlantThemes
import com.example.bloom.data.homeGardenItems
import com.example.bloom.common.navigation.BottomNavigationBar
import com.example.bloom.presentation.ui.recyclerview.ItemHomeGarden
import com.example.bloom.presentation.ui.recyclerview.ItemPlantTheme
import com.example.bloom.presentation.ui.theme.MyTheme

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())

            ) {
                Spacer(modifier = Modifier.height(40.dp))

                SearchInput()

                BrowseThemeSection()

                HomeGardenSection()

            }
        }
    }


}

@Composable
private fun HomeGardenSection() {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .weight(1F)
        )
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = "Filter",
            modifier = Modifier
                .size(24.dp)
        )
    }
    
    Column(
        modifier =Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        homeGardenItems.forEach { theme ->
            ItemHomeGarden(plantTheme = theme)
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