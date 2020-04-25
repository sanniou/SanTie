package com.saniou.santieba.api.bean

import com.sanniou.support.moshi.IgnoreJsonString2List
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FollowList(
    @IgnoreJsonString2List
    @Json(name = "common_follow_list")
    val commonFollowList: List<Follow> = listOf(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "follow_list")
    val followList: List<Follow> = listOf(),
    @Json(name = "has_more")
    val hasMore: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "pn")
    val pn: String = "",
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "total_follow_num")
    val totalFollowNum: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Follow(
        @Json(name = "ala_info")
        val alaInfo: Any = Any(),
        @Json(name = "baijiahao_info")
        val baijiahaoInfo: BaijiahaoInfo = BaijiahaoInfo(),
        @Json(name = "id")
        val id: String = "",
        @Json(name = "intro")
        val intro: String = "",
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
        val portrait: String = "",
        @Json(name = "portraith")
        val portraith: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class BaijiahaoInfo(
            @Json(name = "auth_desc")
            val authDesc: String = "",
            @Json(name = "auth_id")
            val authId: String = "",
            @Json(name = "avatar")
            val avatar: String = "",
            @Json(name = "avatar_h")
            val avatarH: String = "",
            @Json(name = "brief")
            val brief: String = "",
            @Json(name = "name")
            val name: String = ""
        )
    }
}