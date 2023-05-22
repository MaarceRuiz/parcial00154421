package com.example.myapplication.repositorie

import com.example.myapplication.data.model.DogModel

class DogRepository (private val dogs: MutableList<DogModel>){


    fun getDogs() = dogs

    fun addDogs(dog: DogModel) =dogs.add(dog)
}