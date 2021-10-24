package com.example.bloom.domain.use_cases

import com.example.bloom.common.Resource
import com.example.bloom.data.remote.dto.FoodRecipeDto
import com.example.bloom.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDefaultRecipesUseCase @Inject constructor(
    private val repository: FoodRepository
) {
    operator fun invoke(queries: Map<String, String>): Flow<Resource<FoodRecipeDto>> = flow {
        try {
            emit(Resource.Loading())
            val recipeDetail = repository.getRecipes(queries)
            emit(Resource.Success(recipeDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }

    }
}