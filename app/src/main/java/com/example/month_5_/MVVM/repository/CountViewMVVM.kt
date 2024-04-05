package com.example.month_5_.MVVM.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewMVVM : ViewModel() {
    private val model = CountModelMVVM()
    private val _count = MutableLiveData<Int>()

    // Возвращаем неизменяемый LiveData для наблюдения
    fun getCount(): LiveData<Int> {
        return _count
    }

    init {
        // Инициализируем LiveData значением по умолчанию из модели
        _count.value = model.getCount()
    }

    fun inc() {
        model.inc()
        _count.value = model.getCount() // Обновляем LiveData новым значением
    }

    fun dec() {
        model.dec()
        _count.value = model.getCount() // Обновляем LiveData новым значением
    }
}
