package com.example.myapplication.ui.dog.dogview.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.DogModel
import com.example.myapplication.databinding.DogItemBinding

class DogRecyclerViewHolder (private val binding: DogItemBinding): RecyclerView.ViewHolder(binding.root){
     fun bind(dog: DogModel, clickListener: (DogModel) -> Unit){
     binding.nombreTextView.text = dog.nombre
          binding.razaTextView.text = dog.raza
          binding.pesoTextView.text = dog.peso

          binding.cardView.setOnClickListener {
               clickListener(dog)
          }
     }
}