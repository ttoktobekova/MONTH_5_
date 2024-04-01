package com.example.month_5_.image

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.month_5_.databinding.ItemImageBinding
import com.example.month_5_.image.model.ImageModel

class PixaAdapter(
    var list: ArrayList<ImageModel>
) : Adapter<PixaAdapter.PixaViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addList(listImage: ArrayList<ImageModel>) {
        list.clear()
        list.addAll(listImage)
        notifyDataSetChanged()
    }

    fun addImages(newImages: ArrayList<ImageModel>) {
        val lastIndex = list.lastIndex
        list.addAll(newImages)
        notifyItemRangeInserted(lastIndex, newImages.size)
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

    class PixaViewHolder(private val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.imgView.load(imageModel.largeImageURL)
        }
    }

}