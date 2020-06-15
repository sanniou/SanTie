package com.saniou.santieba.model.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WebForumPage(
    @Json(name = "data")
    val `data`: Data = Data(),
    @Json(name = "error")
    val error: String = "",
    @Json(name = "no")
    val no: Int = 0
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "android_client_version")
        val androidClientVersion: String = "",
        @Json(name = "frs_data")
        val frsData: FrsData = FrsData(),
        @Json(name = "frs_hotthread_floor")
        val frsHotthreadFloor: String = "",
        @Json(name = "invoke_type")
        val invokeType: Int = 0,
        @Json(name = "is_newfrs")
        val isNewfrs: Int = 0,
        @Json(name = "pb_cut_floor")
        val pbCutFloor: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class FrsData(
            @Json(name = "forum")
            val forum: Forum = Forum()
        ) {
            @JsonClass(generateAdapter = true)
            data class Forum(
                @Json(name = "album_open_photo_frs")
                val albumOpenPhotoFrs: Boolean = false,
                @Json(name = "attrs")
                val attrs: Attrs = Attrs(),
                @Json(name = "avatar")
                val avatar: String = "",
                @Json(name = "cur_score")
                val curScore: Int = 0,
                @Json(name = "data_type")
                val dataType: String = "",
                @Json(name = "first_class")
                val firstClass: String = "",
                @Json(name = "has_frs_star")
                val hasFrsStar: Int = 0,
                @Json(name = "has_postpre")
                val hasPostpre: Boolean = false,
                @Json(name = "has_pro_zone")
                val hasProZone: Boolean = false,
                @Json(name = "id")
                val id: Int = 0,
                @Json(name = "is_exists")
                val isExists: Boolean = false,
                @Json(name = "isImageForum")
                val isImageForum: Boolean = false,
                @Json(name = "is_like")
                val isLike: Int = 0,
                @Json(name = "is_readonly")
                val isReadonly: String = "",
                @Json(name = "is_search_people")
                val isSearchPeople: Boolean = false,
                @Json(name = "is_stage_forum")
                val isStageForum: Boolean = false,
                @Json(name = "level_id")
                val levelId: Int = 0,
                @Json(name = "level_name")
                val levelName: String = "",
                @Json(name = "levelup_score")
                val levelupScore: Int = 0,
                @Json(name = "managers")
                val managers: List<Manager> = listOf(),
                @Json(name = "member_num")
                val memberNum: Int = 0,
                @Json(name = "name")
                val name: String = "",
                @Json(name = "pic_top_type")
                val picTopType: String = "",
                @Json(name = "portrait_url")
                val portraitUrl: String = "",
                @Json(name = "post_num")
                val postNum: Int = 0,
                @Json(name = "pro_thread_num")
                val proThreadNum: Int = 0,
                @Json(name = "second_class")
                val secondClass: String = "",
                @Json(name = "slogan")
                val slogan: String = "",
                @Json(name = "thread_num")
                val threadNum: Int = 0,
                @Json(name = "tids")
                val tids: String = "",
                @Json(name = "user_level")
                val userLevel: Int = 0
            ) {
                @JsonClass(generateAdapter = true)
                data class Attrs(
                    @Json(name = "ala_live_count")
                    val alaLiveCount: Int = 0,
                    @Json(name = "bottle_baw")
                    val bottleBaw: Int = 0,
                    @Json(name = "broadcast")
                    val broadcast: Int = 0,
                    @Json(name = "f_share_img")
                    val fShareImg: String = "",
                    @Json(name = "forum_card")
                    val forumCard: String = "",
                    @Json(name = "frs_app_sug")
                    val frsAppSug: String = "",
                    @Json(name = "frs_banner")
                    val frsBanner: String = "",
                    @Json(name = "group_count_in_forum")
                    val groupCountInForum: Int = 0,
                    @Json(name = "has_forum_tag")
                    val hasForumTag: Int = 0,
                    @Json(name = "have_ad")
                    val haveAd: Int = 0,
                    @Json(name = "is_smart_frs_forum")
                    val isSmartFrsForum: Int = 0,
                    @Json(name = "tab_name")
                    val tabName: String = "",
                    @Json(name = "theme_color")
                    val themeColor: String = "",
                    @Json(name = "ueg_forum_vecotor")
                    val uegForumVecotor: String = "",
                    @Json(name = "zyqdefine")
                    val zyqdefine: Map<String, String> = mapOf(),
                    @Json(name = "zyqfriend")
                    val zyqfriend: List<String> = listOf(),
                    @Json(name = "zyqtitle")
                    val zyqtitle: String = ""
                )

                @JsonClass(generateAdapter = true)
                data class Manager(
                    @Json(name = "id")
                    val id: Int = 0,
                    @Json(name = "name")
                    val name: String = ""
                )
            }
        }
    }
}