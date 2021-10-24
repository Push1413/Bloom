package com.example.bloom.data.remote

import com.example.bloom.data.remote.dto.FoodRecipeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodyAPI {

    @GET("/recipes/complexSearch")
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): FoodRecipeDto
}