package com.saniou.santieba.kts

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
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

fun Activity.startActivityEx(clazz: Class<out Activity>, vararg strings: String) {
    val intent = Intent(this, clazz)
    strings.forEachIndexed { index, s ->
        if (index % 2 != 0) {
            intent.putExtra(strings[index - 1], s)
        }
    }
    startActivity(intent)
}

fun <T : ViewModel> FragmentActivity.getViewModel(clazz: Class<T>) =
    ViewModelProviders.of(this).get(clazz)

fun <T : ViewDataBinding> Activity.setDataBindingContentView(layout: Int) =
    DataBindingUtil.setContentView<T>(this, layout)

fun Any.isEmpty() = ObjectUtils.isEmpty(this)

fun Drawable.tintDrawable(i: Int): Drawable {
    this.mutate().setColorFilter(i, PorterDuff.Mode.SRC_ATOP)
    return this
}