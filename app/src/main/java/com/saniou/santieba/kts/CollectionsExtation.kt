package com.saniou.santieba.kts

fun MutableCollection<*>.removeLast() {
    remove(size - 1)
}