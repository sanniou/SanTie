package com.saniou.santieba

import androidx.lifecycle.MutableLiveData

class NoNullLiveData<T>(t: T) : MutableLiveData<T>() {
    init {
        value = t
    }

    override fun getValue(): T {
        return super.getValue()!!
    }
}