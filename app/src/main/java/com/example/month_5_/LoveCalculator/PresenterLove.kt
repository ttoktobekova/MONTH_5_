package com.example.month_5_.LoveCalculator

import android.util.Log
import com.example.month_5_.model.LoveModel
import retrofit2.Call
import retrofit2.Response

class PresenterLove(private val view: LoveView) {
    val api = RetrofitService.api }