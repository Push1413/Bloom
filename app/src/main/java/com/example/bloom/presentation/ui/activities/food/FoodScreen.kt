package com.example.bloom.presentation.ui.activities.food

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bloom.common.navigation.BottomNavigationBar
import com.example.bloom.data.remote.dto.FoodRecipeDto

@Composable
fun FoodScreen(
    navController: NavController,
    viewModel: FoodViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                SetupRecyclerView(state.foodList)
//                Text(text = "api call done with ${state.foodList.results[0].sourceName}")
            }
        }

    }
}

@Composable
private fun SetupRecyclerView(foodList: FoodRecipeDto) {
    LazyColumn(
        modifier =Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(foodList.results){recipe ->
            ItemFood(recipe)
        }
    }
}