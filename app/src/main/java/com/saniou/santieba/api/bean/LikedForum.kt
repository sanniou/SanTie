package com.saniou.santieba.api.bean
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class LikedForum(
    @Json(name = "common_forum_list")
    val commonForumList: CommonForumList = CommonForumList(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "forum_list")
    val forumList: ForumList = ForumList(),
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "time")
    val time: Int = 0
) {
    @JsonClass(generateAdapter = true)
    data class CommonForumList(
        @Json(name = "non-gconforum")
        val nonGconforum: List<NonGconforum> = listOf()
    ) {
        @JsonClass(generateAdapter = true)
        data class NonGconforum(
            @Json(name = "avatar")
            val avatar: String = "",
            @Json(name = "cur_score")
            val curScore: String = "",
            @Json(name = "favo_type")
            val favoType: String = "",
            @Json(name = "id")
            val id: String = "",
            @Json(name = "level_name")
            val levelName: String = "",
            @Json(name = "levelup_score")
            val levelupScore: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "slogan")
            val slogan: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class ForumList(
        @Json(name = "non-gconforum")
        val nonGconforum: List<NonGconforum> = listOf()
    ) {
        @JsonClass(generateAdapter = true)
        data class NonGconforum(
            @Json(name = "avatar")
            val avatar: String = "",
            @Json(name = "cur_score")
            val curScore: String = "",
            @Json(name = "favo_type")
            val favoType: String = "",
            @Json(name = "id")
            val id: String = "",
            @Json(name = "level_id")
            val levelId: String = "",
            @Json(name = "level_name")
            val levelName: String = "",
            @Json(name = "levelup_score")
            val levelupScore: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "slogan")
            val slogan: String = ""
        )
    }
}