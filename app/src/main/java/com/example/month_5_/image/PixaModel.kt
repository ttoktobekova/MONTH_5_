package com.example.month_5_.image

data class PixaModel(
    val hits: ArrayList<ImageModel>


)

data class ImageModel(
    val largeImageURL: String,
    val likes: Int
)