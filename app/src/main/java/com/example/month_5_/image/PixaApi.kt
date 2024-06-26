package com.example.month_5_.image

import com.example.month_5_.image.model.PixaModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    @GET("api/")
    fun getImages(
        @Query("key") key: String = "43159102-6b3007544f2a6d463cbc7fea2",
        @Query("q") searchWord: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 5
    ): Call<PixaModel>
}