package com.example.month_5_.image

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.month_5_.databinding.ItemImageBinding

class PixaAdapter(var list: ArrayList<ImageModel>) : Adapter<PixaAdapter.PixaViewHolder>() {

    fun addList(listImage: ArrayList<ImageModel>) {
        list.addAll(listImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        return PixaViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class PixaViewHolder(val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
                binding.imgView.load(imageModel.largeImageURL)
        }
    }

}