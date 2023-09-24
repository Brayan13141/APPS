package com.example.superheroes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.superheroes.R
import androidx.compose.ui.text.font.Font

val arbuts = FontFamily(
    Font(R.font.arbutus_slab)
)
val otra = FontFamily(
    Font(R.font.anton)
)
// Set of Material typography styles to start with
val typography = Typography(
    displayLarge = TextStyle(
        fontFamily = otra,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = otra,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp
    ),
    labelSmall = TextStyle(
        fontFamily = arbuts,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = arbuts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
