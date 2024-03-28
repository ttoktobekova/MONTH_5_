package com.example.month_5_.LoveCalculator

import android.util.Log
import com.example.month_5_.model.LoveModel
import retrofit2.Call
import retrofit2.Response

class PresenterLove(private val view: LoveView) {
    val api = RetrofitService.api
    fun getLoveData(firstName: String, secondName: String) {
        api.getLove(
            firstName = firstName,
            secondName = secondName,
        ).enqueue(object : retrofit2.Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let { model ->
                    view.showResult(model)
                    //если тут не пусто то заходи сюда
                }.run {
                    //если там пусто зайти сюда
                }
            }

            override fun onFailure(p0: Call<LoveModel>, error: Throwable) {
                Log.e("ololo", "onFilure:${error.message}")
            }

        })

    }

//    fun changeScreen(loveModel: LoveModel) {
//        view.changeHistory(loveModel)
//    }
//
    fun showResult(loveModel: LoveModel) {
        view.showResult(loveModel)
    }

}