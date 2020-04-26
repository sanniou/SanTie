package com.saniou.santieba.api.bean

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Content(
    @Json(name = "text")
    val text: CharSequence = "",
    @Json(name = "type")
    val type: String = "",

    @Json(name = "bsize")
    val bsize: String = "",
    @Json(name = "size")
    val size: String = "",
    @Json(name = "c")
    val c: String = "",
    @Json(name = "is_native_app")
    val isNativeApp: String = "",
    @Json(name = "link")
    val link: String = "",
    @Json(name = "native_app")
    val nativeApp: Any = Any(),
    @Json(name = "uid")
    val uid: String = "",
    @Json(name = "un")
    val un: String = "",
    @Json(name = "big_cdn_src")
    val bigCdnSrc: String = "",
    @Json(name = "cdn_src")
    val cdnSrc: String = "",
    @Json(name = "cdn_src_active")
    val cdnSrcActive: String = "",
    @Json(name = "is_long_pic")
    val isLongPic: String = "",
    @Json(name = "origin_size")
    val originSize: String = "",
    @Json(name = "origin_src")
    val originSrc: String = "",
    @Json(name = "show_original_btn")
    val showOriginalBtn: String = "",

    @Json(name = "e_type")
    val eType: String = "",
    @Json(name = "width")
    val width: String = "",
    @Json(name = "height")
    val height: String = "",
    @Json(name = "during_time")
    val duringTime: String = "",
    @Json(name = "src")
    val src: String = "",

    @Json(name = "voice_md5")
    val voiceMd5: String = "",
    var isPoster: Boolean = false

)

