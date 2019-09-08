package com.saniou.santieba.kts

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun getTimestamp() = System.currentTimeMillis()

fun getCurrentDate() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

fun getDateToString(j: Long) =
    SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date(j * 1000))


fun getStringToDate(str: String) =
    try {
        SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str).time
    } catch (e: ParseException) {
        Date().time
    }

fun getDateToInt(j: Long, i: Int): Int =
    when (i) {
        1 -> SimpleDateFormat("ss", Locale.getDefault()).format(Date(j * 1000)).toInt()
        2 -> SimpleDateFormat("mm", Locale.getDefault()).format(Date(j * 1000)).toInt()
        3 -> SimpleDateFormat("HH", Locale.getDefault()).format(Date(j * 1000)).toInt()
        4 -> SimpleDateFormat("dd", Locale.getDefault()).format(Date(j * 1000)).toInt()
        5 -> SimpleDateFormat("MM", Locale.getDefault()).format(Date(j * 1000)).toInt()
        6 -> SimpleDateFormat("yy", Locale.getDefault()).format(Date(j * 1000)).toInt()
        else -> SimpleDateFormat("yy", Locale.getDefault()).format(Date(j * 1000)).toInt()

    }

fun getDisplayTime(j: Long): CharSequence {
    val dateToInt = getDateToInt(getStringToDate(getCurrentDate()) / 1000 - j, 1)
    val dateToInt2 = getDateToInt(getStringToDate(getCurrentDate()) / 1000 - j, 2)
    val dateToInt3 = getDateToInt(getStringToDate(getCurrentDate()) / 1000 - j, 3)
    val dateToInt4 = getDateToInt(getStringToDate(getCurrentDate()) / 1000 - j, 4)
    val dateToInt5 = getDateToInt(getStringToDate(getCurrentDate()) / 1000 - j, 5)
    val dateToInt6 = getDateToInt(getStringToDate(getCurrentDate()) / 1000 - j, 6)
    if ((dateToInt6 != 70 || dateToInt5 != 1 || dateToInt4 != 1 || dateToInt3 < 8) && (dateToInt6 != 70 || dateToInt5 != 1 || dateToInt4 != 2 || dateToInt3 >= 8)) {
        return getDateToString(j)
    }
    if (dateToInt4 == 1 && dateToInt3 > 8) {
        val sb = StringBuilder()
        sb.append((dateToInt3 - 8).toString())
        sb.append("小时前")
        return sb.toString()
    } else if (dateToInt4 == 2 && dateToInt3 < 8) {
        val sb2 = StringBuilder()
        sb2.append((dateToInt3 + 16).toString())
        sb2.append("小时前")
        return sb2.toString()
    } else if (dateToInt2 > 0) {
        val sb3 = StringBuilder()
        sb3.append(dateToInt2.toString())
        sb3.append("分钟前")
        return sb3.toString()
    } else if (dateToInt <= 0) {
        return ""
    } else {
        val sb4 = StringBuilder()
        sb4.append(dateToInt.toString())
        sb4.append("秒前")
        return sb4.toString()
    }
}