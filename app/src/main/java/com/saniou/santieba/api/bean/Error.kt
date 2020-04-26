package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Error(
    @Json(name = "errmsg")
    val errmsg: String = "",
    @Json(name = "errno")
    val errno: String = "",
    @Json(name = "usermsg")
    val usermsg: String = ""
)