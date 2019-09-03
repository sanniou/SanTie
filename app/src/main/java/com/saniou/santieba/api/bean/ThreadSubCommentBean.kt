package com.saniou.santieba.api.bean

data class ThreadSubComment(
    val anti: Anti,
    val display_forum: DisplayForum,
    val error_code: String,
    val page: Page,
    val post: Post2,
    val server_time: String,
    val subpost_list: List<Subpost>,
    val thread: Thread6,
    val time: Int
)


data class Post2(
    val agree: Agree,
    val arr_video: List<Any>,
    val author: AuthorX,
    val bimg_url: String,
    val content: List<ContentX>,
    val floor: String,
    val id: String,
    val ios_bimg_format: String,
    val is_bubble_thread: String,
    val is_colorfull_thread: String,
    val is_voice: String,
    val is_vote: String,
    val lbs_info: List<Any>,
    val ptype: String,
    val show_squared: String,
    val skin_info: String,
    val time: String,
    val title: String,
    val tpoint_post: String,
    val voice_info: List<Any>
)


data class Subpost(
    val agree: Agree,
    val author: Author,
    val content: List<Content>,
    val floor: String,
    val id: String,
    val is_giftpost: String,
    val location: List<Any>,
    val ptype: String,
    val time: String,
    val title: String
)

data class ContentX(
    val text: String,
    val type: String
)

data class AuthorX(
    val ala_info: AlaInfo,
    val bawu_type: String,
    val gender: String,
    val god_data: String,
    val iconinfo: List<Any>,
    val id: String,
    val is_bawu: String,
    val is_like: String,
    val is_mem: String,
    val level_id: String,
    val name: String,
    val name_show: String,
    val new_tshow_icon: List<Any>,
    val pendant: List<Any>,
    val portrait: String,
    val seal_prefix: String,
    val tb_vip: List<Any>,
    val tshow_icon: List<Any>,
    val type: String,
    val uk: String
)

data class AlaInfo(
    val anchor_level_present: String,
    val anchor_level_previous: String,
    val lat: String,
    val live_type: String,
    val lng: String,
    val location: String,
    val start_time: String
)

data class Thread6(
    val author: AuthorXX,
    val collect_mark_pid: String,
    val collect_status: String,
    val comment_num: String,
    val ecom: String,
    val fid: String,
    val fname: String,
    val id: String,
    val isLzDeleteAll: String,
    val is_ad: String,
    val is_multiforum_thread: String,
    val pids: String,
    val reply_num: String,
    val repost_num: String,
    val thread_id: String,
    val thread_type: String,
    val title: String,
    val topic: Topic,
    val user_id: String,
    val valid_post_num: String
)


data class AuthorXX(
    val ala_info: String,
    val id: String,
    val is_like: String,
    val is_mem: String,
    val level_id: String,
    val name: String,
    val name_show: String,
    val new_tshow_icon: List<Any>,
    val portrait: String,
    val tshow_icon: List<Any>,
    val type: String,
    val uk: String
)

