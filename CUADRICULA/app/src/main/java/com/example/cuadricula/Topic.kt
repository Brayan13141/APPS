package com.example.cuadricula

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val cadena: Int,
    val numero: Int,
    @DrawableRes val imagen: Int
)