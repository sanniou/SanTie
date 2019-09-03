package com.saniou.santieba.api.bean


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