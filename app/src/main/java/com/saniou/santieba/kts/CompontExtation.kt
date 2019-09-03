package com.saniou.santieba.kts

import android.app.Activity
import android.content.Intent
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.sanniou.common.utilcode.util.ObjectUtils

fun Activity.startActivityEx(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}

fun <T : ViewModel> FragmentActivity.getViewModel(clazz: Class<T>) =
    ViewModelProviders.of(this).get<T>(clazz)

fun <T : ViewDataBinding> Activity.setDataBindingContentView(layout: Int) =
    DataBindingUtil.setContentView<T>(this, layout)

fun Any.isEmpty() = ObjectUtils.isEmpty(this)