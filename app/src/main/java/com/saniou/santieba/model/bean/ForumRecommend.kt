package com.saniou.santieba.model.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForumRecommend(
    @Json(name = "banner")
    val banner: List<Banner> = listOf(),
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "forum_create_info")
    val forumCreateInfo: List<Any> = listOf(),
    @Json(name = "forum_dir")
    val forumDir: List<ForumDir> = listOf(),
    @Json(name = "frequently_forum_info")
    val frequentlyForumInfo: List<Any> = listOf(),
    @Json(name = "group_count")
    val groupCount: String = "",
    @Json(name = "hot_search")
    val hotSearch: HotSearch = HotSearch(),
    @Json(name = "is_login")
    val isLogin: String = "",
    @Json(name = "is_mem")
    val isMem: String = "",
    @Json(name = "like_forum")
    val likeForum: List<LikeForum> = listOf(),
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "msign_level")
    val msignLevel: String = "",
    @Json(name = "msign_text")
    val msignText: String = "",
    @Json(name = "msign_valid")
    val msignValid: String = "",
    @Json(name = "nav_tab_info")
    val navTabInfo: List<NavTabInfo> = listOf(),
    @Json(name = "new_banner_info")
    val newBannerInfo: List<Any> = listOf(),
    @Json(name = "new_recommend")
    val newRecommend: List<Any> = listOf(),
    @Json(name = "private_forum_popinfo")
    val privateForumPopinfo: List<Any> = listOf(),
    @Json(name = "recommend")
    val recommend: Recommend = Recommend(),
    @Json(name = "recommend_forum_info")
    val recommendForumInfo: List<RecommendForumInfo> = listOf(),
    @Json(name = "redirect")
    val redirect: String = "",
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "sort_type")
    val sortType: String = "",
    @Json(name = "tag_recommend_forum")
    val tagRecommendForum: List<Any> = listOf(),
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "topic")
    val topic: List<Any> = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class Banner(
        @Json(name = "link")
        val link: String = "",
        @Json(name = "pic_url")
        val picUrl: String = "",
        @Json(name = "title")
        val title: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class ForumDir(
        @Json(name = "child_menu_list")
        val childMenuList: List<ChildMenu> = listOf(),
        @Json(name = "default_logo_url")
        val defaultLogoUrl: String = "",
        @Json(name = "menu_id")
        val menuId: String = "",
        @Json(name = "menu_level")
        val menuLevel: String = "",
        @Json(name = "menu_name")
        val menuName: String = "",
        @Json(name = "menu_type")
        val menuType: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class ChildMenu(
            @Json(name = "menu_id")
            val menuId: String = "",
            @Json(name = "menu_level")
            val menuLevel: String = "",
            @Json(name = "menu_name")
            val menuName: String = "",
            @Json(name = "menu_type")
            val menuType: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class HotSearch(
        @Json(name = "search_title")
        val searchTitle: String = "",
        @Json(name = "search_value")
        val searchValue: SearchValue = SearchValue()
    ) {
        @JsonClass(generateAdapter = true)
        data class SearchValue(
            @Json(name = "desc")
            val desc: String = "",
            @Json(name = "id")
            val id: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "type")
            val type: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class LikeForum(
        @Json(name = "avatar")
        val avatar: String = "",
        @Json(name = "content")
        val content: String = "",
        @Json(name = "forum_id")
        val forumId: String = "",
        @Json(name = "forum_name")
        val forumName: String = "",
        @Json(name = "in_time")
        val inTime: String = "",
        @Json(name = "is_brand_forum")
        val isBrandForum: String = "",
        @Json(name = "is_sign")
        val isSign: String = "",
        @Json(name = "is_top")
        val isTop: String = "",
        @Json(name = "level_id")
        val levelId: String = "",
        @Json(name = "need_trans")
        val needTrans: String = "",
        @Json(name = "tab_info")
        val tabInfo: List<TabInfo> = listOf(),
        @Json(name = "theme_color")
        val themeColor: ThemeColor = ThemeColor()
    ) {
        @JsonClass(generateAdapter = true)
        data class TabInfo(
            @Json(name = "is_general_tab")
            val isGeneralTab: String = "",
            @Json(name = "tab_id")
            val tabId: String = "",
            @Json(name = "tab_name")
            val tabName: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class ThemeColor(
            @Json(name = "dark")
            val dark: Dark = Dark(),
            @Json(name = "day")
            val day: Day = Day(),
            @Json(name = "night")
            val night: Night = Night()
        ) {
            @JsonClass(generateAdapter = true)
            data class Dark(
                @Json(name = "common_color")
                val commonColor: String = "",
                @Json(name = "dark_color")
                val darkColor: String = "",
                @Json(name = "font_color")
                val fontColor: String = "",
                @Json(name = "light_color")
                val lightColor: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Day(
                @Json(name = "common_color")
                val commonColor: String = "",
                @Json(name = "dark_color")
                val darkColor: String = "",
                @Json(name = "font_color")
                val fontColor: String = "",
                @Json(name = "light_color")
                val lightColor: String = "",
                @Json(name = "pattern_image")
                val patternImage: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Night(
                @Json(name = "common_color")
                val commonColor: String = "",
                @Json(name = "dark_color")
                val darkColor: String = "",
                @Json(name = "font_color")
                val fontColor: String = "",
                @Json(name = "light_color")
                val lightColor: String = "",
                @Json(name = "pattern_image")
                val patternImage: String = ""
            )
        }
    }

    @JsonClass(generateAdapter = true)
    data class NavTabInfo(
        @Json(name = "tab_code")
        val tabCode: String = "",
        @Json(name = "tab_id")
        val tabId: String = "",
        @Json(name = "tab_name")
        val tabName: String = "",
        @Json(name = "tab_version")
        val tabVersion: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Recommend(
        @Json(name = "daily_forum")
        val dailyForum: List<Any> = listOf(),
        @Json(name = "recommed_forum")
        val recommedForum: List<RecommedForum> = listOf(),
        @Json(name = "tag_name")
        val tagName: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class RecommedForum(
            @Json(name = "avatar")
            val avatar: String = "",
            @Json(name = "forum_id")
            val forumId: String = "",
            @Json(name = "forum_name")
            val forumName: String = "",
            @Json(name = "is_brand_forum")
            val isBrandForum: String = "",
            @Json(name = "is_like")
            val isLike: String = "",
            @Json(name = "member_count")
            val memberCount: String = "",
            @Json(name = "slogan")
            val slogan: String = "",
            @Json(name = "thread_count")
            val threadCount: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class RecommendForumInfo(
        @Json(name = "avatar")
        val avatar: String = "",
        @Json(name = "forum_id")
        val forumId: String = "",
        @Json(name = "forum_name")
        val forumName: String = "",
        @Json(name = "is_brand_forum")
        val isBrandForum: String = "",
        @Json(name = "is_like")
        val isLike: String = "",
        @Json(name = "member_count")
        val memberCount: String = "",
        @Json(name = "recom_reason")
        val recomReason: String = "",
        @Json(name = "slogan")
        val slogan: String = "",
        @Json(name = "thread_count")
        val threadCount: String = ""
    )
}