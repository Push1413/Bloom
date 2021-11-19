package com.example.bloom.presentation.ui.activities.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.bloom.data.remote.dto.ResultDto

@Composable
fun ItemFood(recipe: ResultDto) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth(),
        elevation = 5.dp
    ) {
        Column() {
            Image(
                painter = rememberImagePainter(recipe.image),
                contentDescription = "Recipe Img",
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = recipe.title,
                modifier = Modifier.padding(5.dp)
            )
        }

    }

}