package com.example.bloom.presentation.ui.activities.food

import com.example.bloom.data.remote.dto.FoodRecipeDto

data class FoodState(
    val isLoading: Boolean = false,
    val foodList: FoodRecipeDto = FoodRecipeDto(emptyList()),
    val error: String = ""
)
