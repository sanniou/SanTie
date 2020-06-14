package com.saniou.santieba.model.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThreadStore(
    @Json(name = "ctime")
    val ctime: Int = 0,
    @Json(name = "error")
    val error: Error = Error(),
    @Json(name = "error_code")
    val errorCode: String = "",
    @Json(name = "error_msg")
    val errorMsg: String = "",
    @Json(name = "logid")
    val logid: Long = 0,
    @Json(name = "server_time")
    val serverTime: String = "",
    @Json(name = "store_thread")
    val storeThread: List<StoreThread> = listOf(),
    @Json(name = "time")
    val time: Int = 0
) {
    @JsonClass(generateAdapter = true)
    data class Error(
        @Json(name = "errmsg")
        val errmsg: String = "",
        @Json(name = "errno")
        val errno: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class StoreThread(
        @Json(name = "author")
        val author: Author = Author(),
        @Json(name = "count")
        val count: Int = 0,
        @Json(name = "create_time")
        val createTime: String = "",
        @Json(name = "floor_num")
        val floorNum: String = "",
        @Json(name = "forum_name")
        val forumName: String = "",
        @Json(name = "god")
        val god: String = "",
        @Json(name = "is_deleted")
        val isDeleted: String = "",
        @Json(name = "is_follow")
        val isFollow: String = "",
        @Json(name = "last_time")
        val lastTime: String = "",
        @Json(name = "mark_pid")
        val markPid: String = "",
        @Json(name = "mark_status")
        val markStatus: String = "",
        @Json(name = "max_pid")
        val maxPid: String = "",
        @Json(name = "media")
        val media: List<Media> = listOf(),
        @Json(name = "min_pid")
        val minPid: String = "",
        @Json(name = "post_no")
        val postNo: String = "",
        @Json(name = "post_no_msg")
        val postNoMsg: String = "",
        @Json(name = "reply_num")
        val replyNum: String = "",
        @Json(name = "status")
        val status: String = "",
        @Json(name = "thread_id")
        val threadId: String = "",
        @Json(name = "thread_type")
        val threadType: String = "",
        @Json(name = "title")
        val title: String = "",
        @Json(name = "type")
        val type: Int = 0
    ) {
        @JsonClass(generateAdapter = true)
        data class Author(
            @Json(name = "lz_uid")
            val lzUid: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "name_show")
            val nameShow: String = "",
            @Json(name = "user_portrait")
            val userPortrait: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Media(
            @Json(name = "big_pic")
            val bigPic: String = "",
            @Json(name = "height")
            val height: String = "",
            @Json(name = "size")
            val size: String = "",
            @Json(name = "small_pic")
            val smallPic: String = "",
            @Json(name = "src")
            val src: String = "",
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
    }
}

const val MEDIA_TYPE_PIC = "pic"
const val MEDIA_TYPE_FLASH = "flash"