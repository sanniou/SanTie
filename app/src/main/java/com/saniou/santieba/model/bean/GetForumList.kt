package com.saniou.santieba.model.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetForumList(
    @Json(name = "anti_info")
    val antiInfo: Any = Any(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error")
    val error: Error = Error(),
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "forum_info")
    val forumInfo: List<ForumInfo> = listOf(),
    @Json(name = "level")
    val level: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "msign_step_num")
    val msignStepNum: String = "",
    @Json(name = "num_notice")
    val numNotice: String = "",
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "show_dialog")
    val showDialog: String = "",
    @Json(name = "sign_max_num")
    val signMaxNum: String = "",
    @Json(name = "sign_new")
    val signNew: String = "",
    @Json(name = "sign_notice")
    val signNotice: String = "",
    @Json(name = "text_color")
    val textColor: String = "",
    @Json(name = "text_mid")
    val textMid: String = "",
    @Json(name = "text_pre")
    val textPre: String = "",
    @Json(name = "text_suf")
    val textSuf: String = "",
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "valid")
    val valid: String = ""
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

    @JsonClass(generateAdapter = true)
    data class ForumInfo(
        @Json(name = "avatar")
        val avatar: String = "",
        @Json(name = "cont_sign_num")
        val contSignNum: String = "",
        @Json(name = "forum_id")
        val forumId: String = "",
        @Json(name = "forum_name")
        val forumName: String = "",
        @Json(name = "is_sign_in")
        val isSignIn: String = "",
        @Json(name = "need_exp")
        val needExp: String = "",
        @Json(name = "user_exp")
        val userExp: String = "",
        @Json(name = "user_level")
        val userLevel: String = ""
    )
}