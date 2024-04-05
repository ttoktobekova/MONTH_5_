package com.example.month_5_.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.month_5_.MVVM.repository.CountViewMVVM
import com.example.month_5_.MVVM.repository.Repository
import com.example.month_5_.model.LoveModel

class LoveViewModel : ViewModel() {
  private  val repository = Repository()
    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
}