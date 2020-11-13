package com.example.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData as MutableLiveData

class MainViewModel(): ViewModel() {
    val soma = MutableLiveData<Int>().apply { value = 0 }
    fun incremento(valor:Int) {
        soma.value.let {
            soma.value = soma.value?.plus(valor)
        }
    }
    fun zerar() {
        soma.value = 0
    }
}