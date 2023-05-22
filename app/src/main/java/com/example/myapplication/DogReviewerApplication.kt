package com.example.myapplication

import android.app.Application
import com.example.myapplication.data.dogs
import com.example.myapplication.repositorie.DogRepository

class DogReviewerApplication: Application() {
    val dogRepository: DogRepository by lazy {
        DogRepository(dogs)
    }
}