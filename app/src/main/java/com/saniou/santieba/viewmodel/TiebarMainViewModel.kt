package com.saniou.santieba.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sanniou.support.components.BaseViewModel
import com.sanniou.support.lifecycle.LatestLiveData
import com.sanniou.support.lifecycle.SingleLiveData

class TiebarMainViewModel : BaseViewModel() {
    val appmenu = SingleLiveData<Int>()
    val appTitle = MutableLiveData<CharSequence>()
    val menuClicked = LatestLiveData<Int>()
}