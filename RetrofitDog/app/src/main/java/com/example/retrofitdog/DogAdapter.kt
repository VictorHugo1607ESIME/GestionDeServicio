package com.example.retrofitdog

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdog.databinding.ListDogAdapterBinding
import com.squareup.picasso.Picasso

class DogAdapter: ListAdapter<String, DogAdapter.ViewHolder>(DiffCallBack) {

    companion object DiffCallBack: DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder {
        val binding: ListDogAdapterBinding = ListDogAdapterBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dogImage: String = getItem(position)
        holder.bind(dogImage)
    }

    inner class ViewHolder(private val binding:ListDogAdapterBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(dogImage: String){
            Log.d("Cargando imagen", dogImage)
            Picasso.get().load(dogImage).into(binding.IVDog)
        }
    }

}