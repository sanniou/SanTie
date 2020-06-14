package com.saniou.santieba.model.api.interfaces

import android.text.TextUtils
import com.blankj.utilcode.util.ScreenUtils.getScreenHeight
import com.blankj.utilcode.util.ScreenUtils.getScreenWidth
import com.blankj.utilcode.util.Utils
import com.saniou.santieba.model.api.reqeust.AccountUtil
import com.saniou.santieba.model.api.reqeust.Config
import com.saniou.santieba.model.api.reqeust.Header
import com.saniou.santieba.model.bean.FloorPage
import com.saniou.santieba.model.bean.ForumPage
import com.saniou.santieba.model.bean.ForumRecommend
import com.saniou.santieba.model.bean.StatusResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface MiniTiebaApi {
    @POST("/c/f/excellent/personalized")
    @FormUrlEncoded
    suspend fun personalized(
        @Field("load_type") load_type: Int,
        @Field("pn") page: Int = 1,
        // @retrofit2.http.Header("client_user_token") client_user_token: String? = AccountUtil.getUid(
        //     Utils.getApp()
        // ),
        @Field("_client_version") client_version: String = "8.0.8.0",
        @retrofit2.http.Header(Header.USER_AGENT) user_agent: String = "bdtb for Android $client_version",
        @Field("cuid_gid") cuid_gid: String = "",
        @Field("need_tags") need_tags: Int = 0,
        @Field("page_thread_count") page_thread_count: Int = 15,
        @Field("pre_ad_thread_count") pre_ad_thread_count: Int = 0,
        @Field("sug_count") sug_count: Int = 0,
        @Field("tag_code") tag_code: Int = 0,
        @Field("q_type") q_type: Int = 1,
        @Field("need_forumlist") need_forumlist: Int = 0,
        @Field("new_net_type") new_net_type: Int = 1,
        @Field("new_install") new_install: Int = 0,
        @Field("request_time") request_time: Long = System.currentTimeMillis(),
        @Field("invoke_source") invoke_source: String = "",
        @Field("scr_dip") scr_dip: String = Config.DENSITY.toString(),
        @Field("scr_h") scr_h: String = getScreenHeight().toString(),
        @Field("scr_w") scr_w: String = getScreenWidth().toString()
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/agree/opAgree")
    @FormUrlEncoded
    suspend fun agree(
        @Field("post_id") postId: String,
        @Field("thread_id") threadId: String,
        // @retrofit2.http.Header("client_user_token") client_user_token: String? = AccountUtil.getUid(
        //     Utils.getApp()
        // ),
        @Field("_client_version") client_version: String = "8.0.8.0",
        @retrofit2.http.Header(Header.USER_AGENT) user_agent: String = "bdtb for Android $client_version",
        @Field("cuid_gid") cuid_gid: String = "",
        @Field("agree_type") agree_type: Int = 2,
        @Field("obj_type") obj_type: Int = 3,
        @Field("op_type") op_type: Int = 0,
        @Field("tbs") tbs: String = AccountUtil.getLoginInfo(Utils.getApp())!!.itbTbs,
        @Field("stoken") stoken: String = AccountUtil.getSToken(Utils.getApp())!!
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/agree/opAgree")
    @FormUrlEncoded
    suspend fun disagree(
        @Field("post_id") postId: String,
        @Field("thread_id") threadId: String,
        @retrofit2.http.Header("client_user_token") client_user_token: String? = AccountUtil.getUid(
            Utils.getApp()
        ),
        @Field("_client_version") client_version: String = "8.0.8.0",
        @retrofit2.http.Header(Header.USER_AGENT) user_agent: String = "bdtb for Android $client_version",
        @Field("cuid_gid") cuid_gid: String = "",
        @Field("agree_type") agree_type: Int = 2,
        @Field("obj_type") obj_type: Int = 3,
        @Field("op_type") op_type: Int = 1,
        @Field("tbs") tbs: String = AccountUtil.getLoginInfo(Utils.getApp())!!.itbTbs,
        @Field("stoken") stoken: String = AccountUtil.getSToken(Utils.getApp())!!
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/f/forum/forumrecommend")
    @FormUrlEncoded
    suspend fun forumRecommend(
        @Field("like_forum") like_forum: String = "1",
        @Field("recommend") recommend: String = "0",
        @Field("topic") topic: String = "0"
    ): ForumRecommend

    @POST("/c/f/frs/page")
    @FormUrlEncoded
    suspend fun forumPage(
        @Field("kw") forumName: String,
        @Field("pn") page: Int = 1,
        @Field("sort_type") sort_type: Int,
        @Field("cid") goodClassifyId: String? = null,
        @Field("is_good") is_good: String? = if (TextUtils.isEmpty(goodClassifyId)) null else "1",
        @Field("q_type") q_type: String = "2",
        @Field("st_type") st_type: String = "tb_forumlist",
        @Field("with_group") with_group: String = "0",
        @Field("rn") rn: String = "20",
        @Field("scr_dip") scr_dip: String = Config.DENSITY.toString(),
        @Field("scr_h") scr_h: String = getScreenHeight().toString(),
        @Field("scr_w") scr_w: String = getScreenWidth().toString()
    ): ForumPage

    @POST("/c/f/pb/floor")
    @FormUrlEncoded
    suspend fun floor(
        @Field("kz") threadId: String,
        @Field("pn") page: Int = 1,
        @Field("pid") postId: String?,
        @Field("spid") subPostId: String?,
        @Field("rn") rn: Int = 20
    ): FloorPage

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/f/forum/like")
    @FormUrlEncoded
    suspend fun userLikeForum(
        @Field("page_no") page: Int = 1,
        @Field("page_size") pageSize: Int = 50,
        @Field("uid") uid: String?,
        @Field("friend_uid") friendUid: String?,
        @Field("is_guest") is_guest: String?
    ): StatusResponse

    @POST("/c/u/feed/userpost")
    @FormUrlEncoded
    suspend fun userPost(
        @Field("uid") uid: String,
        @Field("pn") page: Int = 1,
        @Field("is_thread") is_thread: Int,
        @Field("rn") pageSize: Int = 20,
        @Field("need_content") need_content: Int = 1
    ): StatusResponse

    @POST("/c/f/pb/picpage")
    @FormUrlEncoded
    suspend fun picPage(
        @Field("forum_id") forumId: String,
        @Field("kw") forumName: String,
        @Field("tid") threadId: String,
        @Field("pic_id") picId: String,
        @Field("pic_index") picIndex: String,
        @Field("obj_type") objType: String,
        @Field("page_name") page_name: String = "PB",
        @Field("next") next: Int = 10,
        @Field("user_id") myUid: String? = AccountUtil.getUid(Utils.getApp()),
        @Field("scr_h") scr_h: String = getScreenHeight().toString(),
        @Field("scr_w") scr_w: String = getScreenWidth().toString(),
        @Field("q_type") q_type: Int = 2,
        @Field("prev") prev: Int,
        @Field("not_see_lz") not_see_lz: Int
    ): StatusResponse

    @POST("/c/u/user/profile")
    @FormUrlEncoded
    suspend fun profile(
        @Field("uid") uid: String,
        @Field("need_post_count") need_post_count: Int = 1
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/forum/unlike")
    @FormUrlEncoded
    suspend fun unlikeForum(
        @Field("fid") forumId: String,
        @Field("kw") forumName: String,
        @Field("tbs") tbs: String? = AccountUtil.getLoginInfo(Utils.getApp())?.itbTbs
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/forum/like")
    @FormUrlEncoded
    suspend fun likeForum(
        @Field("fid") forumId: String,
        @Field("kw") forumName: String,
        @Field("tbs") tbs: String? = AccountUtil.getLoginInfo(Utils.getApp())?.itbTbs
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/forum/sign")
    @FormUrlEncoded
    suspend fun sign(
        @Field("kw") forumName: String,
        @Field("tbs") tbs: String
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/bawu/delthread")
    @FormUrlEncoded
    suspend fun delThread(
        @Field("fid") forumId: String,
        @Field("word") forumName: String,
        @Field("z") threadId: String,
        @Field("tbs") tbs: String,
        @Field("src") src: Int = 1,
        @Field("is_vipdel") is_vip_del: Int = 0,
        @Field("delete_my_post") delete_my_post: Int = 1
    ): StatusResponse

    @Headers("${Header.FORCE_LOGIN}: ${Header.FORCE_LOGIN_TRUE}")
    @POST("/c/c/bawu/delpost")
    @FormUrlEncoded
    suspend fun delPost(
        @Field("fid") forumId: String,
        @Field("word") forumName: String,
        @Field("z") threadId: String,
        @Field("pid") postId: String,
        @Field("tbs") tbs: String,
        @Field("isfloor") is_floor: Int,
        @Field("src") src: Int,
        @Field("is_vipdel") is_vip_del: Int,
        @Field("delete_my_post") delete_my_post: Int
    ): StatusResponse

    @POST("/c/s/searchpost")
    @FormUrlEncoded
    suspend fun searchPost(
        @Field("word") keyword: String,
        @Field("kw") forumName: String,
        @Field("pn") page: Int = 1,
        @Field("rn") pageSize: Int = 30,
        @Field("only_thread") only_thread: Int = 0
    ): StatusResponse

    @GET("/mo/q/search/user")
    suspend fun searchUser(
        @Query("word") keyword: String,
        @retrofit2.http.Header("client_user_token") client_user_token: String? = AccountUtil.getUid(
            Utils.getApp()
        ),
        @Query("_client_version") client_version: String = "8.0.8.0",
        @retrofit2.http.Header(Header.USER_AGENT) user_agent: String = "bdtb for Android $client_version",
        @Query("cuid_gid") cuid_gid: String = ""
    ): StatusResponse
}