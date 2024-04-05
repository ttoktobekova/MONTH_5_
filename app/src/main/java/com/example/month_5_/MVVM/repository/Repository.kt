package com.example.month_5_.MVVM.repository

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import com.example.month_5_.LoveCalculator.RetrofitService
import com.example.month_5_.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository() {
    private val api = RetrofitService.api
    fun getData(firstName: String, secondName: String): MediatorLiveData<LoveModel> {
        val liveData = MediatorLiveData<LoveModel>()

        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveData.postValue(it)
                    }
                } else {
                    Log.e("Repository", "onResponse: Request failed with code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<LoveModel>, error: Throwable) {
                Log.e("Repository", "onFailure: ${error.message}", error)
            }
        })

        return liveData
    }

}
