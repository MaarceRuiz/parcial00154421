package com.example.myapplication.data

import com.example.myapplication.data.model.DogModel


val nombre = "Max"
val raza = "Labrador"
val despcripcion = "Es jugueton y le gusta comer 4 veces al dia"
val peso = "3"

val nombre2 = "Max"
val raza2 = "Labrador"
val despcripcion2 = "Es jugueton y le gusta comer 4 veces al dia"
val peso2 = "3"

val dogs = mutableListOf(
    DogModel(nombre, raza, despcripcion, peso) ,
            DogModel(nombre2, raza2, despcripcion2, peso2)
)