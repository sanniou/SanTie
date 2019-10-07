package com.saniou.santieba.utils

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("linkMovementMethod")
fun setMovementMethod(view: TextView, flag: Boolean) {
    view.movementMethod = LinkMovementMethod.getInstance()
}