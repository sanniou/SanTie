package com.saniou.santieba.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DislikeBean(
    @Json(name = "tid") var threadId: String,
    @Json(name = "dislike_ids") var dislikeIds: String,
    @Json(name = "fid") var forumId: String,
    @Json(name = "click_time") var clickTime: Long,
    var extra: String
) {

    fun setThreadId(threadId: String): DislikeBean {
        this.threadId = threadId
        return this
    }

    fun setDislikeIds(dislikeIds: String): DislikeBean {
        this.dislikeIds = dislikeIds
        return this
    }

    fun setForumId(forumId: String): DislikeBean {
        this.forumId = forumId
        return this
    }

    fun setClickTime(clickTime: Long): DislikeBean {
        this.clickTime = clickTime
        return this
    }

    fun setExtra(extra: String): DislikeBean {
        this.extra = extra
        return this
    }
}