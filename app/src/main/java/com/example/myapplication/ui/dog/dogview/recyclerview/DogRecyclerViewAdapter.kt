package com.example.myapplication.ui.dog.dogview.recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.DogModel
import com.example.myapplication.databinding.DogItemBinding

class DogRecyclerViewAdapter (private val clickListener: (DogModel)-> Unit
): RecyclerView.Adapter<DogRecyclerViewHolder>() {
    private val dogs = ArrayList<DogModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogRecyclerViewHolder {
        val binding = DogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
    return dogs.size
    }

    override fun onBindViewHolder(holder: DogRecyclerViewHolder, position: Int) {
        val dog= dogs[position]
        holder.bind(dog, clickListener)
    }
    fun setData(dogsList: List<DogModel>) {
        dogs.clear()
        dogs.addAll(dogsList)
    }
}