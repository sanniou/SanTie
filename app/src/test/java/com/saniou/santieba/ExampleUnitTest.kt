package com.saniou.santieba

import androidx.databinding.ObservableArrayList
import org.junit.Test

import org.junit.Assert.*
import java.util.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val a =ObservableArrayList<Int>()
        a.add(1)
        a.add(2)
        a.add(3)
        a.add(4)


        a.removeAll(a.subList(0,2))
        println(a.size)
    }
}
