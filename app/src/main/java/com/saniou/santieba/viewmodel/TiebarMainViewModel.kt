package com.saniou.santieba.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sanniou.support.components.BaseViewModel
import com.sanniou.support.lifecycle.LatestLiveEvent
import com.sanniou.support.lifecycle.SingleLiveEvent

class TiebarMainViewModel : BaseViewModel() {
    val appmenu = SingleLiveEvent<Int>()
    val appTitle = MutableLiveData<CharSequence>()
    val menuClicked = LatestLiveEvent<Int>()
}