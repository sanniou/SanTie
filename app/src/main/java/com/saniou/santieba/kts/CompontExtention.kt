package com.saniou.santieba.kts

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sanniou.common.utilcode.util.ObjectUtils


inline fun <reified T : Activity> Activity.startActivityEx() {
    startActivity(Intent(this, T::class.java))
}

fun Activity.setOnclickListener(id: Int, listener: View.OnClickListener) =
    findViewById<View>(id)?.setOnClickListener(listener)

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(
    factory: ViewModelProvider.Factory? = null
) =
    ViewModelProviders.of(this, factory).get(T::class.java)

inline fun <reified T : ViewModel> Fragment.getViewModel(
    factory: ViewModelProvider.Factory? = null
) =
    ViewModelProviders.of(this, factory).get(T::class.java)

/**
 * not do null check
 */
inline fun <reified T : ViewModel> Fragment.getActivityViewModel(
    factory: ViewModelProvider.Factory? = null
) =
    ViewModelProviders.of(activity!!, factory).get(T::class.java)


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

fun <T : ViewDataBinding> Activity.setDataBindingContentView(layout: Int) =
    DataBindingUtil.setContentView<T>(this, layout)

fun Any.isEmpty() = ObjectUtils.isEmpty(this)

fun Drawable.tintDrawable(i: Int): Drawable {
    this.mutate().setColorFilter(i, PorterDuff.Mode.SRC_ATOP)
    return this
}

