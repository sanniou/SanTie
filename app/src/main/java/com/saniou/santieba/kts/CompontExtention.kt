package com.saniou.santieba.kts

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable

inline fun <reified T : Activity> Activity.startActivityEx() {
    startActivity(Intent(this, T::class.java))
}

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

fun Drawable.tintDrawable(i: Int): Drawable {
    this.mutate().setColorFilter(i, PorterDuff.Mode.SRC_ATOP)
    return this
}

