package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatusResponse(
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = ""

)