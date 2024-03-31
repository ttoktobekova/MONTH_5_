package com.example.month_5_.Injector

import com.example.month_5_.COUNT.CountModel
import com.example.month_5_.COUNT.CountView
import com.example.month_5_.COUNT.Presenter

class Injector {
    companion object{
        fun getModel() = CountModel()
        fun getPresenter (view: CountView) = Presenter(view)
    }
}