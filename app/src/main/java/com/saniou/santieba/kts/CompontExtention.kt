package com.saniou.santieba.kts

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable

inline fun <reified T : Activity> Context.startActivityEx() {
    startActivity(Intent(this, T::class.java))
}

fun Context.startActivityEx(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}

inline fun <reified T : Activity> Context.startActivityEx(vararg strings: String) {
    val intent = Intent(this, T::class.java)
    strings.forEachIndexed { index, s ->
        if (index % 2 != 0) {
            intent.putExtra(strings[index - 1], s)
        }
    }
    startActivity(intent)
}

fun Context.startActivityEx(clazz: Class<out Activity>, vararg strings: String) {
    val intent = Intent(this, clazz)
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

