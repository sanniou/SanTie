package com.saniou.santieba.api.bean


data class PostS(
    val author: AuthorR,
    val cid: String,
    val content: String,
    val fname: String,
    val is_floor: String,
    val is_replay: String,
    val pid: String,
    val thread_type: String,
    val tid: String,
    val time: Long,
    val title: String
)

