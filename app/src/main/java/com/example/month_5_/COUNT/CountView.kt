package com.example.month_5_.COUNT

import android.graphics.Color
import android.widget.Toast
import android.content.Context as Context

interface CountView {
    fun showCount(count:Int)
    fun showToast(text:String)
    fun setColor(color:Int, count: Int)
}