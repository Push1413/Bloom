package com.example.bloom.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FoodRecipeDto(
    @SerializedName("results")
    val results: List<ResultDto>
)



