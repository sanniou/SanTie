package com.saniou.santieba.api.bean
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class FeedThread(
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error")
    val error: Error = Error(),
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "feed_thread_list")
    val feedThreadList: List<FeedThreadX> = listOf(),
    @Json(name = "has_more")
    val hasMore: String = "",
    @Json(name = "is_new_url")
    val isNewUrl: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "time")
    val time: Int = 0,
    @Json(name = "total")
    val total: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Error(
        @Json(name = "errmsg")
        val errmsg: String = "",
        @Json(name = "errno")
        val errno: String = "",
        @Json(name = "usermsg")
        val usermsg: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class FeedThreadX(
        @Json(name = "abstract")
        val `abstract`: List<Abstract> = listOf(),
        @Json(name = "create_time")
        val createTime: String = "",
        @Json(name = "forum_id")
        val forumId: String = "",
        @Json(name = "forum_name")
        val forumName: String = "",
        @Json(name = "is_good")
        val isGood: String = "",
        @Json(name = "is_manypostnum")
        val isManypostnum: String = "",
        @Json(name = "is_top")
        val isTop: String = "",
        @Json(name = "is_up")
        val isUp: String = "",
        @Json(name = "is_voice_thread")
        val isVoiceThread: String = "",
        @Json(name = "media")
        val media: List<Media> = listOf(),
        @Json(name = "modify_time")
        val modifyTime: String = "",
        @Json(name = "post_num")
        val postNum: String = "",
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
        @Json(name = "user_pic_url")
        val userPicUrl: String = "",
        @Json(name = "userinfo")
        val userinfo: Userinfo = Userinfo(),
        @Json(name = "video_info")
        val videoInfo: VideoInfo = VideoInfo()
    ) {
        @JsonClass(generateAdapter = true)
        data class Abstract(
            @Json(name = "text")
            val text: String = "",
            @Json(name = "type")
            val type: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Media(
            @Json(name = "big_pic")
            val bigPic: String = "",
            @Json(name = "is_long_pic")
            val isLongPic: String = "",
            @Json(name = "pic_info")
            val picInfo: String = "",
            @Json(name = "post_id")
            val postId: String = "",
            @Json(name = "show_original_btn")
            val showOriginalBtn: String = "",
            @Json(name = "src")
            val src: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "vhsrc")
            val vhsrc: String = "",
            @Json(name = "vpic")
            val vpic: String = "",
            @Json(name = "vsrc")
            val vsrc: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Userinfo(
            @Json(name = "iconinfo")
            val iconinfo: List<Any> = listOf(),
            @Json(name = "tshow_icon")
            val tshowIcon: List<TshowIcon> = listOf()
        ) {
            @JsonClass(generateAdapter = true)
            data class TshowIcon(
                @Json(name = "icon")
                val icon: String = "",
                @Json(name = "name")
                val name: String = "",
                @Json(name = "url")
                val url: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class VideoInfo(
            @Json(name = "auditing")
            val auditing: String = "",
            @Json(name = "format_matched")
            val formatMatched: String = "",
            @Json(name = "is_private")
            val isPrivate: String = "",
            @Json(name = "origin_video_url")
            val originVideoUrl: String = "",
            @Json(name = "thumbnail_height")
            val thumbnailHeight: String = "",
            @Json(name = "thumbnail_url")
            val thumbnailUrl: String = "",
            @Json(name = "thumbnail_width")
            val thumbnailWidth: String = "",
            @Json(name = "video_desc")
            val videoDesc: List<VideoDesc> = listOf(),
            @Json(name = "video_duration")
            val videoDuration: String = "",
            @Json(name = "video_height")
            val videoHeight: String = "",
            @Json(name = "video_length")
            val videoLength: String = "",
            @Json(name = "video_log_id")
            val videoLogId: String = "",
            @Json(name = "video_md5")
            val videoMd5: String = "",
            @Json(name = "video_type")
            val videoType: String = "",
            @Json(name = "video_url")
            val videoUrl: String = "",
            @Json(name = "video_width")
            val videoWidth: String = ""
        ) {
            @JsonClass(generateAdapter = true)
            data class VideoDesc(
                @Json(name = "video_height")
                val videoHeight: String = "",
                @Json(name = "video_id")
                val videoId: String = "",
                @Json(name = "video_size")
                val videoSize: String = "",
                @Json(name = "video_url")
                val videoUrl: String = "",
                @Json(name = "video_width")
                val videoWidth: String = ""
            )
        }
    }
}