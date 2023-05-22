package com.example.myapplication.ui.dog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.DogReviewerApplication
import com.example.myapplication.data.model.DogModel
import com.example.myapplication.repositorie.DogRepository

class DogViewModel (private val repository: DogRepository) : ViewModel(){
    var nombre = MutableLiveData("")
    var raza = MutableLiveData("")
    var descripcion = MutableLiveData("")
    var peso =   MutableLiveData("")
    var status = MutableLiveData("")


    fun getDogs() = repository.getDogs()
    private fun addDogs(dog:DogModel) = repository.addDogs(dog)

    fun createDog(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val dog = DogModel(
            nombre.value!!,
            raza.value!!,
            descripcion.value!!,
            peso.value!!,
        )
        addDogs(dog)
        clearData()

        status.value = DOG_CREATED

    }
     private fun validateData(): Boolean {
         when{
             nombre.value.isNullOrEmpty() -> return false
             raza.value.isNullOrEmpty() -> return false
             descripcion.value.isNullOrEmpty() -> return false
             peso.value.isNullOrEmpty() -> return false
         }
         return true
     }
    fun clearData(){
        nombre.value = ""
        raza.value = ""
        descripcion.value = ""
        peso.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE

    }

    fun setSelectedDog(dog: DogModel){
        nombre.value = dog.nombre
        raza.value = dog.raza
        descripcion.value =dog.descripcion
        peso.value = dog.peso
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as DogReviewerApplication
                DogViewModel(app.dogRepository)
            }
        }

        const val DOG_CREATED = "Dog created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }


}