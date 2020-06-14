package com.saniou.santieba.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class UploadResultBean {
    @Json(name = "error_code")
    val errorCode = 0

    @Json(name = "error_msg")
    val errorMsg: String? = null
    val info: UploadInfo? = null

    inner class UploadInfo {
        @Json(name = "pic_id")
        var picId: String? = null
            private set
        var width: String? = null
            private set
        var height: String? = null
            private set

        @Json(name = "pic_url")
        val picUrl: String? = null

        fun setPicId(picId: String?): UploadInfo {
            this.picId = picId
            return this
        }

        fun setWidth(width: String?): UploadInfo {
            this.width = width
            return this
        }

        fun setHeight(height: String?): UploadInfo {
            this.height = height
            return this
        }

        val pic: String
            get() = """
                #(pic,$picId,$width,$height)

                """.trimIndent()
    }
}