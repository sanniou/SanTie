package com.saniou.santieba.model.api.interfaces

import android.text.TextUtils
import com.saniou.santieba.model.api.reqeust.Header
import com.saniou.santieba.model.bean.StatusResponse
import com.saniou.santieba.model.bean.UserInfo
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface WebTiebaApi {
    @Headers(
        "${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}"
    )
    @GET
    suspend fun follow(
        @Url url: String
    ): StatusResponse

    @Headers(
        "${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}"
    )
    @GET
    suspend fun unfollow(
        @Url url: String
    ): StatusResponse

    @GET("/mo/q/hotMessage/main")
    suspend fun hotTopicMain(
        @Query("topic_id") topicId: String,
        @Query("yuren_rand") yurenRand: String,
        @Query("topic_name") topicName: String,
        @Query("pmy_topic_ext") pmyTopicExt: String
    ): StatusResponse

    @GET("/mo/q/hotMessage/forum")
    suspend fun hotTopicForum(
        @Query("topic_id") topicId: String,
        @Query("yuren_rand") yurenRand: String,
        @Query("topic_name") topicName: String,
        @Query("pmy_topic_ext") pmyTopicExt: String
    ): StatusResponse

    @GET("/mo/q/hotMessage/thread")
    suspend fun hotTopicThread(
        @Query("topic_id") topicId: String,
        @Query("yuren_rand") yurenRand: String,
        @Query("topic_name") topicName: String,
        @Query("pmy_topic_ext") pmyTopicExt: String,
        @Query("page") page: Int,
        @Query("num") num: Int = 30,
        @Query("forum_id") forum_id: String = ""
    ): StatusResponse

    @GET("/mo/q/hotMessage")
    suspend fun hotTopic(
        @Query("topic_id") topicId: String,
        @Query("topic_name") topicName: String,
        @Query("fr") fr: String = "newwise"
    ): StatusResponse

    @GET("/mo/q/hotMessage/list?fr=newwise")
    suspend fun hotMessageList(): StatusResponse

    @GET("/f")
    suspend fun frs(
        @Query("kw") forumName: String,
        @Query("pn") pn: Int,
        @Query("sort_type") sort_type: Int,
        @Query("cid") cid: String?,
        @Query("lm") lm: String? = if (!TextUtils.isEmpty(cid)) "4" else null,
        @Query("fr") fr: String = "newwise"
    ): StatusResponse

    @Headers(
        "${Header.ADD_COOKIE}: ${Header.ADD_COOKIE_FALSE}"
    )
    @GET("/mo/q/newmoindex?need_user=1")
    suspend fun myInfo(
        @retrofit2.http.Header("cookie") cookie: String
    ): UserInfo

    @GET("/mo/q/search/forum")
    suspend fun searchForum(
        @Query("word") keyword: String
    ): StatusResponse

    @GET("/mo/q/search/thread")
    suspend fun searchThread(
        @Query("word") keyword: String,
        @Query("pn") page: Int,
        @Query("st") order: String,
        @Query("tt") filter: String,
        @Query("ct") ct: String = "2"
    ): StatusResponse

    @Headers(
        "${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}"
    )
    @POST("/mo/q/cooluploadpic")
    @FormUrlEncoded
    suspend fun webUploadPic(
        @Field("pic") base64: String?,
        @Query("type") type: String = "ajax",
        @Query("r") r: String = Math.random().toString()
    ): StatusResponse

    @Headers(
        "${Header.HOST}: tieba.baidu.com",
        "${Header.ORIGIN}: https://tieba.baidu.com",
        "X-Requested-With: XMLHttpRequest"
    )
    @POST("/mo/q/apubpost")
    @FormUrlEncoded
    suspend fun webReply(
        @Query("_t") _t_url: Long = System.currentTimeMillis(),
        @Field("co") content: String,
        @Field("_t") _t_form: Long = System.currentTimeMillis(),
        @Field("tag") tag: String = "11",
        @Field("upload_img_info") imgInfo: String,
        @Field("fid") forumId: String,
        @Field("src") src: String = "1",
        @Field("word") forumName: String,
        @Field("tbs") tbs: String,
        @Field("z") threadId: String,
        @Field("lp") lp: String = "6026",
        @Field("nick_name") nickName: String,
        @Field("pid") postId: String? = null,
        @Field("lzl_id") replyPostId: String? = null,
        @Field("floor") floor: String? = null,
        @Field("_BSK") bsk: String,
        @retrofit2.http.Header(Header.REFERER) referer: String
    ): StatusResponse
}