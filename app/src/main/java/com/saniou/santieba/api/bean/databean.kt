package com.saniou.santieba.api.bean

sealed class TieResponse {
    abstract fun getErrorCode(): Int
    abstract fun getErrorMessage(): String
}

data class StatusResponse(
    val error_code: Int,
    val error_msg: String
) : TieResponse() {
    override fun getErrorMessage() = error_msg

    override fun getErrorCode() = error_code
}

data class Forum2(
    val ctime: Int,
    val error_code: Int,
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
) : TieResponse() {
    override fun getErrorMessage() = "d"

    override fun getErrorCode() = error_code
}


data class UserProfile(
    val anti: AnTi,
    val user: UserInfo,
    val error_code: Int
) : TieResponse() {
    override fun getErrorMessage() = "d"
    override fun getErrorCode() = error_code
    data class AnTi(val tbs: String)
    data class UserInfo(val tbs: String)
}


data class ThreadDetail(
    val anti: Anti,
    val ctime: Int,
    val display_forum: DisplayForum,
    val error_code: Int,
    val fold_tip: String,
    val forum: Forum3,
    val has_floor: String,
    val is_new_url: String,
    val news_info: List<Any>,
    val page: Page,
    val partial_visible_toast: String,
    val pb_sort_info: List<PbSortInfo>,
    val post_list: List<Post>,
    val server_time: String,
    val sort_type: String,
    val switch_read_open: String,
    val thread: Thread2,
    val thread_topic: List<ThreadTopic>,
    val time: Int,
    val user: User2,
    val user_list: List<UserXX>
) : TieResponse() {
    override fun getErrorMessage() = "ThreadSubComment"

    override fun getErrorCode() = error_code
}


data class ThreadSubComment(
    val anti: Anti,
    val display_forum: DisplayForum,
    val error_code: Int,
    val page: Page,
    val post: Post2,
    val server_time: String,
    val subpost_list: List<Subpost>,
    val thread: Thread6,
    val time: Int
) : TieResponse() {
    override fun getErrorMessage() = "ThreadSubComment"

    override fun getErrorCode() = error_code
}


data class ThreadProfile(
    val anti: Anti,
    val asp_shown_info: String,
    val bottle: Bottle,
    val ctime: Int,
    val error_code: Int,
    val filter_swan_thread: String,
    val fortune_bag: String,
    val fortune_desc: String,
    val forum: Forum,
    val frs_star: FrsStar,
    val frs_tab_default: String,
    val frs_tab_info: List<FrsTabInfo>,
    val game_default_tab_id: String,
    val gcon_account: GconAccount,
    val is_new_url: String,
    val need_log: String,
    val page: Page,
    val partial_visible_toast: String,
    val private_forum_active_info: PrivateForumActiveInfo,
    val server_time: String,
    val sort_type: String,
    val thread_list: List<Thread>,
    val time: Int,
    val twzhibo_pos: String,
    val user: User,
    val user_extend: UserExtend,
    val video_auto_play: String
) : TieResponse() {
    override fun getErrorMessage() = "ThreadProfile"
    override fun getErrorCode() = error_code
}

data class ForumListP(
    val advert: Advert,
    val anti_info: List<Any>,
    val ctime: Int,
    val error: Error,
    val error_code: Int,
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
) : TieResponse() {
    override fun getErrorMessage() = error.errmsg
    override fun getErrorCode() = error_code

}

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


data class DataDTO(
    val pid: String,
    val status: String,
    val tid: String,
    val type: String
)
