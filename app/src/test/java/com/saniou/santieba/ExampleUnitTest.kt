package com.saniou.santieba

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() = runBlocking {
        val job1 = launch { // ①
            log(1)
            try {
                delay(1000)
            } catch (e: Exception) {
                log("cancelled. $e")
            }
            log(2)
        }
        delay(100)
        log(3)
        job1.cancel() // ③
        log(4)
    }

}

fun log(a:Any)=println("$a")

