package com.saniou.santieba.api.bean

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.sanniou.common.helper.JsonUtils
import java.lang.reflect.Type

data class ThreadDetail(
    val anti: Anti,
    val banner_list: BannerList,
    val ctime: Int,
    val display_forum: DisplayForum,
    val error_code: String,
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
)

data class User2(
    val agree_num: String,
    val bawu_type: String,
    val fans_nickname: String,
    val fans_num: String,
    val gender: String,
    val gift_num: String,
    val god_data: String,
    val has_concerned: String,
    val id: String,
    val is_bawu: String,
    val is_mem: String,
    val level_id: String,
    val name: String,
    val name_show: String,
    val new_tshow_icon: List<Any>,
    val portrait: String,
    val seal_prefix: String,
    val thread_num: String,
    val tshow_icon: List<Any>
)

data class PbSortInfo(
    val sort_name: String,
    val sort_type: String
)

data class DisplayForum(
    val avatar: String,
    val first_class: String,
    val id: String,
    val is_brand_forum: String,
    val is_exists: String,
    val is_liked: String,
    val name: String,
    val ext: String,
    val is_signed: String,
    val level_id: String,
    val second_class: String
)

data class Forum3(
    val avatar: String,
    val first_class: String,
    val id: String,
    val is_brand_forum: String,
    val is_exists: String,
    val is_liked: String,
    val name: String,
    val second_class: String
)

data class Thread2(
    val author: Author2,
    val collect_mark_pid: String,
    val collect_status: String,
    val create_time: String,
    val id: String,
    val is_activity: String,
    val is_bazhu_apply: String,
    val is_bub: String,
    val is_link_thread: String,
    val is_ntitle: String,
    val is_partial_visible: String,
    val no_smart_pb: String,
    val pids: String,
    val post_id: String,
    val reply_num: String,
    val repost_num: String,
    val share_num: String,
    val t_share_img: String,
    val thread_info: ThreadInfo,
    val thread_type: String,
    val title: String,
    val topic: Topic
)


data class Author2(
    val agree_num: String,
    val bawu_type: String,
    val esport_data: String,
    val fans_nickname: String,
    val fans_num: String,
    val gender: String,
    val gift_num: String,
    val god_data: String,
    val has_concerned: String,
    val id: String,
    val is_bawu: String,
    val is_like: String,
    val level_id: String,
    val name: String,
    val name_show: String,
    val new_tshow_icon: List<NewTshowIcon>,
    val portrait: String,
    val priv_sets: PrivSets,
    val seal_prefix: String,
    val thread_num: String,
    val tshow_icon: List<TshowIcon>,
    val type: String
)

data class NewTshowIcon(
    val icon: String,
    val name: String,
    val url: String
)

data class TshowIcon(
    val icon: String,
    val name: String,
    val url: String
)


data class ThreadInfo(
    val agree_num: String,
    val antispam_info: AntispamInfo,
    val create_time: String,
    val first_post_id: String,
    val forum_id: String,
    val forum_name: String,
    val freq_num: String,
    val from_thread_id: String,
    val good_types: String,
    val is_deleted: String,
    val last_modified_time: String,
    val last_post_deleted: String,
    val last_post_id: String,
    val last_user_id: String,
    val last_user_ip: String,
    val last_user_ip6: String,
    val phone_type: String,
    val post_num: String,
    val readable_tags: String,
    val storecount: String,
    val thread_classes: String,
    val thread_id: String,
    val thread_types: String,
    val title: String,
    val title_prefix: String,
    val top_types: String,
    val tstore_type: String,
    val user_id: String,
    val user_ip: String,
    val user_ip6: String,
    val vote_id: String
)

data class AntispamInfo(
    val deepimginfo_score: String,
    val ocr_score: String,
    val porn: String,
    val porn_score: String,
    val replyRnnScore: String,
    val scoreNum_porn: String,
    val scoreNum_porn_title: String,
    val sexy_score: String,
    val textScore: String,
    val threadRnnScore: String,
    val urate_score: String
)


data class Topic(
    val is_live_post: String,
    val is_topic: String,
    val lpost_type: String,
    val topic_type: String,
    val is_lpost: String,
    val link: String
)

data class UserXX(
    val bimg_end_time: String,
    val bimg_url: String,
    val id: String,
    val ios_bimg_format: String,
    val is_like: String,
    val is_login: String,
    val is_manager: String,
    val is_mem: String,
    val is_select_tail: String,
    val left_call_num: String,
    val level_id: String,
    val name: String,
    val name_show: String,
    val pay_member_info: PayMemberInfo,
    val portrait: String,
    val seal_prefix: String,
    val type: String
)

data class PayMemberInfo(
    val end_time: String,
    val pic_url: String,
    val props_id: String
)

data class ThreadTopic(
    val topic_name: String
)


data class Post(
    val arr_video: List<Any>,
    val author_id: String,
    val bimg_url: String,
    val content: List<Content>,
    val floor: String,
    val fold_tip: String,
    val from_thread_id: String,
    val has_signature: String,
    val id: String,
    val ios_bimg_format: String,
    val is_fold: String,
    val is_post_visible: String,
    val is_top_agree_post: String,
    val is_vote: String,
    val need_log: String,
    val show_squared: String,
    val sub_post_list: SubPostDetail,
    val sub_post_number: Int,
    val time: String,
    val title: String,
    val v_forum_id: String
)

data class SubPostDetail(
    val pid: String,
    val sub_post_list: List<SubContent>
)

class SubPostDetailConverter : JsonDeserializer<SubPostDetail> {
    override fun deserialize(
        json: JsonElement, typeOfT: Type, context: JsonDeserializationContext
    ): SubPostDetail? {
        if (json.isJsonObject) {
            return JsonUtils.fromJson(json.toString(), typeOfT)
        }
        return null
    }

}

data class SubContent(
    val author_id: String,
    val content: List<Content>,
    val floor: String,
    val id: String,
    val time: String,
    val title: String
)


data class Content(
    val big_cdn_src: String,
    val bsize: String,
    val cdn_src: String,
    val cdn_src_active: String,
    val is_long_pic: String,
    val origin_size: String,
    val origin_src: String,
    val show_original_btn: Int,
    val size: String,
    val c: String,
    val text: CharSequence,
    val type: String
)
