package com.saniou.santieba.api

import com.saniou.santieba.api.bean.*
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TiebaService {
    @POST("f/forum/sug")
    @FormUrlEncoded
    suspend fun searchForum(@FieldMap params: Map<String, String>): ForumSug

    @POST("s/searchpost")
    @FormUrlEncoded
    suspend fun searchpost(@FieldMap params: Map<String, String>): SearchPost

    @POST("s/msg")
    @FormUrlEncoded
    suspend fun msg(@FieldMap params: Map<String, String>): StatusResponse

    @POST("c/forum/unlike")
    @FormUrlEncoded
    suspend fun unlikeForum(@FieldMap params: Map<String, String>): StatusResponse

    @POST("c/forum/like")
    @FormUrlEncoded
    suspend fun likeForum(@FieldMap params: Map<String, String>): StatusResponse

    @POST("f/post/threadstore")
    @FormUrlEncoded
    suspend fun threadstore(@FieldMap params: Map<String, String>): ThreadStore

    @POST("c/post/addstore")
    @FormUrlEncoded
    suspend fun addStore(@FieldMap params: Map<String, String>): StatusResponse

    @POST("c/thread/add")
    @FormUrlEncoded
    suspend fun addThread(@FieldMap params: Map<String, String>): StatusResponse

    @POST("c/post/add")
    @FormUrlEncoded
    suspend fun addReply(@FieldMap params: Map<String, String>): StatusResponse

    @POST("c/post/add")
    @FormUrlEncoded
    suspend fun addReply2Someone(@FieldMap params: Map<String, String>): StatusResponse

    @POST("c/post/rmstore")
    @FormUrlEncoded
    suspend fun rmStore(@FieldMap params: Map<String, String>): StatusResponse

    @POST("c/forum/sign")
    @FormUrlEncoded
    suspend fun sign(@FieldMap params: Map<String, String>): Sign

    @POST("f/forum/getforumlist")
    @FormUrlEncoded
    suspend fun getforumlist(@FieldMap params: Map<String, String>): GetForumList

    @POST("c/forum/msign")
    @FormUrlEncoded
    suspend fun msign(@FieldMap params: Map<String, String>): Msign

    @POST("u/feed/replyme")
    @FormUrlEncoded
    suspend fun replyme(@FieldMap params: Map<String, String>): StatusResponse

    @POST("u/feed/atme")
    @FormUrlEncoded
    suspend fun atme(@FieldMap params: Map<String, String>): StatusResponse

    @POST("u/feed/userpost")
    @FormUrlEncoded
    suspend fun userPost(@FieldMap params: Map<String, String>): StatusResponse

    @POST("u/user/profile")
    @FormUrlEncoded
    suspend fun profile(@FieldMap params: Map<String, String>): Profile

    @POST("u/user/profile")
    @FormUrlEncoded
    suspend fun friendProfile(@FieldMap params: Map<String, String>): Profile

    @POST("f/frs/page")
    @FormUrlEncoded
    suspend fun forumPage(@FieldMap params: Map<String, String>): ForumPage

    @POST("f/pb/page")
    @FormUrlEncoded
    suspend fun threadPage(@FieldMap params: Map<String, String>): ThreadPage

    @POST("f/forum/forumrecommend")
    @FormUrlEncoded
    suspend fun forumRecommend(@FieldMap params: Map<String, String>): ForumRecommend

    @POST("f/pb/floor")
    @FormUrlEncoded
    suspend fun subFloor(@FieldMap params: Map<String, String>): FloorPage
}


