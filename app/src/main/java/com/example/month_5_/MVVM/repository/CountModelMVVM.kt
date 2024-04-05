package com.example.month_5_.MVVM.repository

class CountModelMVVM {
    private var count: Int = 0

    fun getCount(): Int {
        return count
    }

    fun inc() {
        count++
    }

    fun dec() {
        count--
    }
}