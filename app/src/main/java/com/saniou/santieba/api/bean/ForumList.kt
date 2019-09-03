package com.saniou.santieba.api.bean

data class ForumListP(
    val advert: Advert,
    val anti_info: List<Any>,
    val ctime: Int,
    val error: Error,
    val error_code: String,
    val forum_info: List<ForumListInfo>,
    val level: String,
    val logid: Int,
    val msign_step_num: String,
    val num_notice: String,
    val server_time: String,
    val show_dialog: String,
    val sign_max_num: String,
    val sign_new: String,
    val sign_notice: String,
    val text_color: String,
    val text_mid: String,
    val text_pre: String,
    val text_suf: String,
    val time: Int,
    val title: String,
    val valid: String
)

data class Advert(
    val banner_pic: String,
    val banner_url: String
)

data class Error(
    val errmsg: String,
    val errno: String,
    val usermsg: String
)

data class ForumListInfo(
    val avatar: String,
    val cont_sign_num: String,
    val forum_id: String,
    val forum_name: String,
    val is_sign_in: Int,
    val need_exp: String,
    val user_exp: String,
    val user_level: String
)