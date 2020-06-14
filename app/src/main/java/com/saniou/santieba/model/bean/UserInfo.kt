package com.saniou.santieba.model.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserInfo(
    @Json(name = "data")
    val `data`: Data = Data(),
    @Json(name = "error")
    val error: String = "",
    @Json(name = "no")
    val no: Int = 0
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "concern_num")
        val concernNum: Int = 0,
        @Json(name = "email")
        val email: String = "",
        @Json(name = "fans_num")
        val fansNum: Int = 0,
        @Json(name = "id")
        val id: Int = 0,
        @Json(name = "indextk")
        val indextk: String = "",
        @Json(name = "intro")
        val intro: String = "",
        @Json(name = "is_half_user")
        val isHalfUser: Int = 0,
        @Json(name = "is_login")
        val isLogin: Boolean = false,
        @Json(name = "is_verify")
        val isVerify: Boolean = false,
        @Json(name = "itb_tbs")
        val itbTbs: String = "",
        @Json(name = "like_forum_num")
        val likeForumNum: Int = 0,
        @Json(name = "mParr_props")
        val mParrProps: List<Any> = listOf(),
        @Json(name = "mobilephone")
        val mobilephone: String = "",
        @Json(name = "name")
        val name: String = "",
        // @Json(name = "name_link")
        // val nameLink: Any = Any(),
        @Json(name = "name_show")
        val nameShow: String = "",
        @Json(name = "no_un")
        val noUn: String = "",
        @Json(name = "portrait")
        val portrait: String = "",
        @Json(name = "portrait_url")
        val portraitUrl: String = "",
        @Json(name = "post_num")
        val postNum: Int = 0,
        @Json(name = "profile_index")
        val profileIndex: String = "",
        @Json(name = "sid")
        val sid: String = "",
        @Json(name = "source_id")
        val sourceId: Int = 0,
        @Json(name = "tbs")
        val tbs: String = "",
        @Json(name = "temp_name")
        val tempName: String = "",
        @Json(name = "uid")
        val uid: Int = 0,
        @Json(name = "user_sex")
        val userSex: Int = 0
    )
}