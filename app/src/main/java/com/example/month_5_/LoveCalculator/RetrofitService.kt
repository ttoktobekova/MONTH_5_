package com.example.month_5_.LoveCalculator

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private var retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    //для формирование модельки в gson
    val api = retrofit.create(loveApi::class.java)

}