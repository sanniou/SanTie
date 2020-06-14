package com.saniou.santieba.kts

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment

inline fun <reified T : Activity> Context.startActivityEx() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Fragment.startActivityEx(vararg strings: String) =
    context?.startActivityEx<T>(*strings)

inline fun <reified T : Activity> Fragment.startActivityEx() = context?.startActivityEx<T>()

inline fun <reified T : Activity> Context.startActivityEx(vararg strings: String) {
    val intent = Intent(this, T::class.java)
    strings.forEachIndexed { index, s ->
        if (index % 2 != 0) {
            intent.putExtra(strings[index - 1], s)
        }
    }
    startActivity(intent)
}

fun Drawable.tintDrawable(i: Int): Drawable {
    this.mutate().setColorFilter(i, PorterDuff.Mode.SRC_ATOP)
    return this
}

