package com.saniou.santieba.api.bean

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataDTO(
    val pid: String,
    val status: String,
    val tid: String,
    val type: String
)