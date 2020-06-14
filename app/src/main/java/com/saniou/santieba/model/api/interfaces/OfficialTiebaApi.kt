package com.saniou.santieba.model.api.interfaces

import com.blankj.utilcode.util.ScreenUtils.getScreenHeight
import com.blankj.utilcode.util.ScreenUtils.getScreenWidth
import com.blankj.utilcode.util.Utils
import com.saniou.santieba.model.api.reqeust.AccountUtil
import com.saniou.santieba.model.api.reqeust.Config
import com.saniou.santieba.model.api.reqeust.Header
import com.saniou.santieba.model.bean.StatusResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface OfficialTiebaApi {
    @POST("/c/f/pb/page")
    @FormUrlEncoded
    suspend fun threadContent(
        @Field("kz") threadId: String,
        @Field("pn") page: Int,
        @Field("last") last: String?,
        @Field("r") r: String?,
        @Field("lz") lz: Int,
        @Field("st_type") st_type: String = "tb_frslist",
        @Field("back") back: String = "0",
        @Field("floor_rn") floor_rn: String = "3",
        @Field("mark") mark: String = "0",
        @Field("rn") rn: String = "30",
        @Field("with_floor") with_floor: String = "1",
        @Field("scr_dip") scr_dip: String = Config.DENSITY.toString(),
        @Field("scr_h") scr_h: String = getScreenHeight().toString(),
        @Field("scr_w") scr_w: String = getScreenWidth().toString()
    ): StatusResponse

    @POST("/c/f/pb/page")
    @FormUrlEncoded
    suspend fun threadContent(
        @Field("kz") threadId: String,
        @Field("pid") postId: String?,
        @Field("last") last: String?,
        @Field("r") r: String?,
        @Field("lz") lz: Int,
        @Field("st_type") st_type: String = "tb_frslist",
        @Field("back") back: String = "0",
        @Field("floor_rn") floor_rn: String = "3",
        @Field("mark") mark: String = "0",
        @Field("rn") rn: String = "30",
        @Field("with_floor") with_floor: String = "1",
        @Field("scr_dip") scr_dip: String = Config.DENSITY.toString(),
        @Field("scr_h") scr_h: String = getScreenHeight().toString(),
        @Field("scr_w") scr_w: String = getScreenWidth().toString()
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/excellent/submitDislike")
    @FormUrlEncoded
    suspend fun submitDislike(
        @Field("dislike") dislike: String,
        @Field("dislike_from") dislike_from: String = "homepage",
        @Field("stoken") stoken: String = AccountUtil.getSToken(Utils.getApp())!!
    ): StatusResponse
}