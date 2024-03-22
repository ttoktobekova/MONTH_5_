package com.example.month_5_.ui.COUNT

import com.example.month_5_.Injector.Injector
import com.example.month_5_.R

class Presenter (private var countView: CountView){
    private val model = Injector.getModel()

    fun increment() {
        //Я написала 14 потому что индекс начинаеться с нуля и код все правильно работает
        if (model.count ==14) {
            countView.setColor(R.color.purple_500, model.count)
        }
        if (model.count ==9){
            countView.showToast("Поздравляю")
        }
        //T
        //T
        model.inc()
        countView.showCount(model.count)
    }
    fun decrement() {
        model.des()
        countView.showCount(model.count)
    }
}
