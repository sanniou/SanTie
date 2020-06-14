package com.saniou.santieba.model.bean
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class UserPost(
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "hide_post")
    val hidePost: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "mask_type")
    val maskType: String = "",
    @Json(name = "post_list")
    val postList: List<Post> = listOf(),
    @Json(name = "reddot_deleted_thread")
    val reddotDeletedThread: String = "",
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "view_card_num")
    val viewCardNum: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Post(
        @Json(name = "abstract")
        val `abstract`: List<Abstract> = listOf(),
        @Json(name = "agree")
        val agree: Agree = Agree(),
        @Json(name = "agree_num")
        val agreeNum: String = "",
        @Json(name = "anchor_info")
        val anchorInfo: List<Any> = listOf(),
        @Json(name = "baijiahao_info")
        val baijiahaoInfo: BaijiahaoInfo = BaijiahaoInfo(),
        @Json(name = "content")
        val content: String = "",
        @Json(name = "create_time")
        val createTime: String = "",
        @Json(name = "first_post_content")
        val firstPostContent: List<FirstPostContent> = listOf(),
        @Json(name = "forum_id")
        val forumId: String = "",
        @Json(name = "forum_name")
        val forumName: String = "",
        @Json(name = "freq_num")
        val freqNum: String = "",
        @Json(name = "ip")
        val ip: String = "",
        @Json(name = "is_ntitle")
        val isNtitle: String = "",
        @Json(name = "is_post_deleted")
        val isPostDeleted: String = "",
        @Json(name = "is_pro_thread")
        val isProThread: String = "",
        @Json(name = "is_remain")
        val isRemain: String = "",
        @Json(name = "is_thread")
        val isThread: String = "",
        @Json(name = "is_view_year")
        val isViewYear: String = "",
        @Json(name = "media")
        val media: List<Media> = listOf(),
        @Json(name = "multiple_forum_list")
        val multipleForumList: List<MultipleForum> = listOf(),
        @Json(name = "name_show")
        val nameShow: String = "",
        // @Json(name = "poll_info")
        // val pollInfo: List<Any> = listOf(),
        @Json(name = "post_id")
        val postId: String = "",
        @Json(name = "ptype")
        val ptype: String = "",
        @Json(name = "reply_num")
        val replyNum: String = "",
        @Json(name = "share_num")
        val shareNum: String = "",
        @Json(name = "thread_id")
        val threadId: String = "",
        @Json(name = "thread_type")
        val threadType: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "user_id")
        val userId: String = "",
        @Json(name = "user_name")
        val userName: String = "",
        @Json(name = "user_portrait")
        val userPortrait: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Abstract(
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Agree(
            @Json(name = "agree_num")
            val agreeNum: String = "",
            @Json(name = "agree_type")
            val agreeType: String = "",
            @Json(name = "diff_agree_num")
            val diffAgreeNum: String = "",
            @Json(name = "disagree_num")
            val disagreeNum: String = "",
            @Json(name = "has_agree")
            val hasAgree: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class BaijiahaoInfo(
            @Json(name = "auth_desc")
            val authDesc: String = "",
            @Json(name = "auth_id")
            val authId: String = "",
            @Json(name = "avatar")
            val avatar: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class FirstPostContent(
            @Json(name = "bsize")
            val bsize: String = "",
            @Json(name = "c")
            val c: String = "",
            @Json(name = "link")
            val link: String = "",
            @Json(name = "origin_size")
            val originSize: String = "",
            @Json(name = "origin_src")
            val originSrc: String = "",
            @Json(name = "size")
            val size: String = "",
            @Json(name = "src")
            val src: String = "",
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "uid")
            val uid: String = "",
            @Json(name = "un")
            val un: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Media(
            @Json(name = "big_pic")
            val bigPic: String = "",
            @Json(name = "dynamic_pic")
            val dynamicPic: String = "",
            @Json(name = "height")
            val height: String = "",
            @Json(name = "is_long_pic")
            val isLongPic: String = "",
            @Json(name = "origin_pic")
            val originPic: String = "",
            @Json(name = "post_id")
            val postId: String = "",
            @Json(name = "show_original_btn")
            val showOriginalBtn: String = "",
            @Json(name = "small_pic")
            val smallPic: String = "",
            @Json(name = "src")
            val src: String = "",
            @Json(name = "src_pic")
            val srcPic: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "vhsrc")
            val vhsrc: String = "",
            @Json(name = "vpic")
            val vpic: String = "",
            @Json(name = "vsrc")
            val vsrc: String = "",
            @Json(name = "water_pic")
            val waterPic: String = "",
            @Json(name = "width")
            val width: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class MultipleForum(
            @Json(name = "forum_id")
            val forumId: String = "",
            @Json(name = "forum_name")
            val forumName: String = ""
        )
    }
}