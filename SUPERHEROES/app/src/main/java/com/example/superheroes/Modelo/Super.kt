package com.example.superheroes.Modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Super (
        @StringRes val nombresuper: Int,
        val descripcion: String,
        @DrawableRes val imagen: Int
)