package com.example.bloom.data.repository

import com.example.bloom.data.remote.FoodyAPI
import com.example.bloom.data.remote.dto.FoodRecipeDto
import com.example.bloom.domain.repository.FoodRepository
import retrofit2.Response
import javax.inject.Inject

class FoodRepoImpl @Inject constructor(
    private val api: FoodyAPI
) : FoodRepository {
    override suspend fun getRecipes(queries: Map<String, String>): FoodRecipeDto {
        return api.getRecipes(queries)
    }
}