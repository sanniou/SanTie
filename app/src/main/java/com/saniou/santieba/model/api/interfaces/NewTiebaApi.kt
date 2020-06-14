package com.saniou.santieba.model.api.retrofit.interfaces

import com.saniou.santieba.model.api.reqeust.Header
import com.saniou.santieba.model.bean.StatusResponse
import com.saniou.santieba.model.bean.ThreadStore
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface NewTiebaApi {
    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/s/msg")
    @FormUrlEncoded
    suspend fun msg(
        @Field("bookmark") bookmark: Int = 1
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/f/post/threadstore")
    @FormUrlEncoded
    suspend fun threadStore(
        @Field("rn") pageSize: Int,
        @Field("offset") offset: Int,
        @Field("user_id") user_id: String?
    ): ThreadStore

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/post/rmstore")
    @FormUrlEncoded
    suspend fun removeStore(
        @Field("tid") threadId: String,
        @Field("tbs") tbs: String
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/post/addstore")
    @FormUrlEncoded
    suspend fun addStore(
        @Field("data") data: String,
        @Field("tbs") tbs: String
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/u/feed/replyme")
    @FormUrlEncoded
    suspend fun replyMe(
        @Field("pn") page: Int = 0
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/u/feed/atme")
    @FormUrlEncoded
    suspend fun atMe(
        @Field("pn") page: Int = 0
    ): StatusResponse
}