/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bloom.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.bloom.R

// Set of Material typography styles to start with
private val NunitoBold = FontFamily(Font(R.font.nunitosans_bold))
private val NunitoSemiBold = FontFamily(Font(R.font.nunitosans_semibold))
private val NunitoLight = FontFamily(Font(R.font.nunitosans_light))

val typography = Typography(
    h1 = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 18.sp,
    ),
    h2 = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = NunitoLight,
        fontSize = 16.sp,
    ),
    body1 = TextStyle(
        fontFamily = NunitoLight,
        fontSize = 14.sp,
    ),
    body2 = TextStyle(
        fontFamily = NunitoLight,
        fontSize = 12.sp,
    ),
    button = TextStyle(
        fontFamily = NunitoSemiBold,
        fontSize = 14.sp,
        letterSpacing = 1.sp,
    ),
    caption = TextStyle(
        fontFamily = NunitoSemiBold,
        fontSize = 12.sp,
    )
)
