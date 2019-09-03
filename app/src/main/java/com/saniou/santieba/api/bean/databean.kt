package com.saniou.santieba.api.bean

data class Forum2(
    val ctime: Int,
    val error_code: String,
    val forum_create_info: List<Any>,
    val forum_dir: List<ForumDir>,
    val frequently_forum_info: List<Any>,
    val group_count: String,
    val hot_search: HotSearch,
    val is_login: String,
    val is_mem: String,
    val like_forum: List<LikeForum>,
    val msign_level: String,
    val msign_text: String,
    val msign_valid: String,
    val new_banner_info: List<Any>,
    val new_recommend: List<Any>,
    val private_forum_popinfo: List<Any>,
    val recommend: Recommend,
    val recommend_forum_info: List<Any>,
    val redirect: String,
    val server_time: String,
    val sort_type: String,
    val tag_recommend_forum: List<Any>,
    val time: Int,
    val topic: List<Any>
)

data class Recommend(
    val daily_forum: List<Any>,
    val recommed_forum: List<RecommedForum>,
    val tag_name: String
)

data class RecommedForum(
    val avatar: String,
    val forum_id: String,
    val forum_name: String,
    val is_brand_forum: String,
    val is_like: String,
    val member_count: String,
    val slogan: String,
    val thread_count: String
)

data class ForumDir(
    val child_menu_list: List<ChildMenu>,
    val default_logo_url: String,
    val menu_id: String,
    val menu_level: String,
    val menu_name: String,
    val menu_type: String
)

data class ChildMenu(
    val menu_id: String,
    val menu_level: String,
    val menu_name: String,
    val menu_type: String
)

data class HotSearch(
    val search_title: String,
    val search_value: SearchValue
)

data class SearchValue(
    val desc: String,
    val id: String,
    val name: String,
    val type: String
)

data class LikeForum(
    val avatar: String,
    val content: String,
    val forum_id: String,
    val forum_name: String,
    val in_time: String,
    val is_brand_forum: String,
    val is_sign: Int,
    val is_top: String,
    val level_id: Int,
    val need_trans: String,
    val theme_color: ThemeColor
)

data class ThemeColor(
    val day: ThemeProfile,
    val night: ThemeProfile
)

data class ThemeProfile(
    val common_color: String,
    val dark_color: String,
    val font_color: String,
    val light_color: String,
    val pattern_image: String
)
