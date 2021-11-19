package com.example.bloom.presentation.ui.activities.food

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloom.common.Constant.API_KEY
import com.example.bloom.common.Constant.DEFAULT_DIET_TYPE
import com.example.bloom.common.Constant.DEFAULT_MEAL_TYPE
import com.example.bloom.common.Constant.DEFAULT_RECIPES_NUMBER
import com.example.bloom.common.Constant.QUERY_ADD_RECIPE_INFORMATION
import com.example.bloom.common.Constant.QUERY_API_KEY
import com.example.bloom.common.Constant.QUERY_DIET
import com.example.bloom.common.Constant.QUERY_FILL_INGREDIENTS
import com.example.bloom.common.Constant.QUERY_NUMBER
import com.example.bloom.common.Constant.QUERY_TYPE
import com.example.bloom.common.Resource
import com.example.bloom.data.remote.dto.FoodRecipeDto
import com.example.bloom.domain.use_cases.GetDefaultRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val useCase: GetDefaultRecipesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(FoodState())
    val state: State<FoodState> = _state

    init {
        val queries: HashMap<String, String> = HashMap()
        queries[QUERY_NUMBER] = DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = DEFAULT_MEAL_TYPE
        queries[QUERY_DIET] = DEFAULT_DIET_TYPE
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"
        getDefaultRecipe(queries)
    }

    private fun getDefaultRecipe(queries: java.util.HashMap<String, String>) {
        useCase.invoke(queries = queries).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = FoodState(foodList = result.data ?: FoodRecipeDto(emptyList()))
                }
                is Resource.Error -> {
                    _state.value = FoodState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = FoodState(
                        isLoading = true
                    )
                }
            }

        }.launchIn(viewModelScope)
    }

}