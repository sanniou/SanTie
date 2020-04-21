package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForumSug(
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "fname")
    val fname: List<String> = listOf(),
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "time")
    val time: Int = 0
)
