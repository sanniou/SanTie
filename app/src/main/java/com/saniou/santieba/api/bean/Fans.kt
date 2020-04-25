package com.saniou.santieba.api.bean
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class Fans(
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "page")
    val page: Page = Page(),
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "user_list")
    val userList: List<User> = listOf()
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
    data class User(
        @Json(name = "has_concerned")
        val hasConcerned: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "intro")
        val intro: String = "",
        @Json(name = "is_followed")
        val isFollowed: String = "",
        @Json(name = "is_friend")
        val isFriend: String = "",
        @Json(name = "live_id")
        val liveId: String = "",
        @Json(name = "live_status")
        val liveStatus: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_show")
        val nameShow: String = "",
        @Json(name = "portrait")
        val portrait: String = ""
    )
}