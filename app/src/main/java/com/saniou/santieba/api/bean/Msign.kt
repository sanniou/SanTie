package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Msign(
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error")
    val error: Error = Error(),
    @Json(name = "error_code")
    val errorCode: String = "",
    // @Json(name = "info")
    // val info: Any = Any(),
    @Json(name = "is_timeout")
    val isTimeout: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "show_dialog")
    val showDialog: String = "",
    @Json(name = "sign_notice")
    val signNotice: String = "",
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "timeout_notice")
    val timeoutNotice: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Error(
        @Json(name = "errmsg")
        val errmsg: String = "",
        @Json(name = "errno")
        val errno: String = "",
        @Json(name = "usermsg")
        val usermsg: String = ""
    )
}