package com.example.superheroes.Modelo

import com.example.superheroes.R

    object ListaHeroes{
        val heroes = listOf(
            Super(nombresuper = R.string.hero1, descripcion = R.string.description1.toString(), imagen = R.drawable.android_superhero1),
            Super(nombresuper = R.string.hero2, descripcion = R.string.description2.toString(), imagen = R.drawable.android_superhero2),
            Super(nombresuper = R.string.hero3, descripcion = R.string.description3.toString(), imagen = R.drawable.android_superhero3),
            Super(nombresuper = R.string.hero4, descripcion = R.string.description4.toString(), imagen = R.drawable.android_superhero4),
            Super(nombresuper = R.string.hero5, descripcion = R.string.description5.toString(), imagen = R.drawable.android_superhero5),
            Super(nombresuper = R.string.hero6, descripcion = R.string.description6.toString(), imagen = R.drawable.android_superhero6)
        )
    }