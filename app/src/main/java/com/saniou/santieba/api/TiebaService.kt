package com.saniou.santieba.api

import com.saniou.santieba.api.bean.*
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

interface TiebaService {
    @POST("c/forum/sign")
    @FormUrlEncoded
    fun sign(@FieldMap params: Map<String, String>): Observable<Objects>

    @POST("f/forum/getforumlist")
    @FormUrlEncoded
    fun getforumlist(@FieldMap params: Map<String, String>): Observable<ForumListP>

    @POST("c/forum/msign")
    @FormUrlEncoded
    fun msign(@FieldMap params: Map<String, String>): Observable<Objects>

    @POST("u/user/profile")
    @FormUrlEncoded
    fun profile(@FieldMap params: Map<String, String>): Observable<String>

    @POST("f/frs/page")
    @FormUrlEncoded
    fun postPage(@FieldMap params: Map<String, String>): Observable<ThreadProfile>

    @POST("f/pb/page")
    @FormUrlEncoded
    fun threadDetail(@FieldMap params: Map<String, String>): Observable<ThreadDetail>

    @POST("f/forum/forumrecommend")
    @FormUrlEncoded
    fun getFavorite(@FieldMap params: Map<String, String>): Observable<Forum2>

    @POST("f/pb/floor")
    @FormUrlEncoded
    fun getSubFloor(@FieldMap params: Map<String, String>): Observable<ThreadSubComment>
}