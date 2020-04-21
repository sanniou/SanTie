package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchPost(
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "page")
    val page: Page = Page(),
    @Json(name = "post_list")
    val postList: List<Post> = listOf(),
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "time")
    val time: Int = 0
) {
    @JsonClass(generateAdapter = true)
    data class Page(
        @Json(name = "current_page")
        val currentPage: String = "",
        @Json(name = "has_more")
        val hasMore: String = "",
        @Json(name = "has_prev")
        val hasPrev: String = "",
        @Json(name = "offset")
        val offset: String = "",
        @Json(name = "page_size")
        val pageSize: String = "",
        @Json(name = "total_count")
        val totalCount: String = "",
        @Json(name = "total_page")
        val totalPage: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Post(
        @Json(name = "author")
        val author: Author = Author(),
        @Json(name = "cid")
        val cid: String = "",
        @Json(name = "content")
        val content: String = "",
        @Json(name = "fname")
        val fname: String = "",
        @Json(name = "is_floor")
        val isFloor: String = "",
        @Json(name = "is_replay")
        val isReplay: String = "",
        @Json(name = "pid")
        val pid: String = "",
        @Json(name = "thread_type")
        val threadType: String = "",
        @Json(name = "tid")
        val tid: String = "",
        @Json(name = "time")
        val time: String = "",
        @Json(name = "title")
        val title: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Author(
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_show")
            val nameShow: String = ""
        )
    }
}