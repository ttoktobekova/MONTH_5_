package com.example.month_5_.image.model

import java.io.Serializable

data class PixaModel(
    val hits: ArrayList<ImageModel>
):Serializable

data class ImageModel(
    val largeImageURL: String,
    val likes: Int
)