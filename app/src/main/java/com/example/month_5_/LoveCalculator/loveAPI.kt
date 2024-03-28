package com.example.month_5_.LoveCalculator

import com.example.month_5_.model.LoveModel
import com.example.month_5_.ui.COUNT.Presenter
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface loveApi {
    @GET("getPercentage")
    fun getLove(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "e6eb10b8b5msh44de7b3fb08dee3p1235c9jsn5855c92318a6",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): retrofit2.Call<LoveModel>
}