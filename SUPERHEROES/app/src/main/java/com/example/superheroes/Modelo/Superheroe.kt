package com.example.superheroes.Modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroes.R

data class Superheroe(
    @StringRes val nombresuper: Int,
    val descripcion: Int,
    @DrawableRes val imagen: Int)

object listaHeroes{
    val heroes = listOf(
        Superheroe(nombresuper = R.string.hero1, descripcion = R.string.description1, imagen = R.drawable.android_superhero1),
        Superheroe(nombresuper = R.string.hero2, descripcion = R.string.description2, imagen = R.drawable.android_superhero2),
        Superheroe(nombresuper = R.string.hero3, descripcion = R.string.description3, imagen = R.drawable.android_superhero3),
        Superheroe(nombresuper = R.string.hero4, descripcion = R.string.description4, imagen = R.drawable.android_superhero4),
        Superheroe(nombresuper = R.string.hero5, descripcion = R.string.description5, imagen = R.drawable.android_superhero5),
        Superheroe(nombresuper = R.string.hero6, descripcion = R.string.description6, imagen = R.drawable.android_superhero6)
    )
}