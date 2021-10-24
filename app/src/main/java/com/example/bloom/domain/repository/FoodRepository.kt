package com.example.bloom.domain.repository

import com.example.bloom.data.remote.dto.FoodRecipeDto
import retrofit2.Response

interface FoodRepository {

    suspend fun getRecipes(queries: Map<String, String>): FoodRecipeDto

}