package com.saniou.santieba.api

import android.util.Log
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.SPUtils
import com.saniou.santieba.api.bean.DataDTO
import com.saniou.santieba.api.bean.Fans
import com.saniou.santieba.api.bean.FeedThread
import com.saniou.santieba.api.bean.FloorPage
import com.saniou.santieba.api.bean.FollowList
import com.saniou.santieba.api.bean.FollowResponse
import com.saniou.santieba.api.bean.Follows
import com.saniou.santieba.api.bean.ForumPage
import com.saniou.santieba.api.bean.ForumRecommend
import com.saniou.santieba.api.bean.ForumSug
import com.saniou.santieba.api.bean.GetForumList
import com.saniou.santieba.api.bean.LikedForum
import com.saniou.santieba.api.bean.Msign
import com.saniou.santieba.api.bean.Profile
import com.saniou.santieba.api.bean.SearchPost
import com.saniou.santieba.api.bean.Sign
import com.saniou.santieba.api.bean.StatusResponse
import com.saniou.santieba.api.bean.ThreadPage
import com.saniou.santieba.api.bean.ThreadStore
import com.saniou.santieba.api.bean.UserPost
import com.saniou.santieba.constant.BOOLEAN_FALSE
import com.saniou.santieba.constant.BOOLEAN_TRUE
import com.saniou.santieba.constant.EMOJI
import com.saniou.santieba.constant.ERROR_CODE_SUCCESS
import com.saniou.santieba.constant.HOST
import com.saniou.santieba.constant.LINK
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.kts.getTimestamp
import com.saniou.santieba.utils.StringUtil
import com.saniou.santieba.viewmodel.MARK_STATE
import com.sanniou.support.exception.ApiErrorException
import com.sanniou.support.extensions.orEmpty
import com.sanniou.support.moshi.EmptyListToNull
import com.sanniou.support.moshi.IgnoreString2Object
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types
import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.apache.commons.lang3.StringUtils
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.FieldMap
import java.io.File
import java.util.TreeMap
import java.util.UUID
import kotlin.math.floor

object TiebaRequest : TiebaService {
    private var clientId: String
    private var netType: String
    private var littleTail: String
    private var tbs: String
    private var uid: String
    private var BDUSS: String
    private var imei: String
    private var preferences: SPUtils
    private var loginInfo: SPUtils
    private var phoneInfo: SPUtils
    private var clientType: String
    private var clientVersion: String
    private var addClientVersion: String
    private var newClientVersion: String
    private val headers = HashMap<String, String>()
    private val tiebaService: TiebaService

    val moshi: Moshi

    init {
        headers["Cookie"] = "ka=open"
        headers["net"] = "3"
        headers["User-Agent"] = "bdtb for Android 6.9.2.1"
        headers["Pragma"] = "no-cache"

        moshi = Moshi.Builder()
            .add(EmptyListToNull())
            .add(IgnoreString2Object())
            .add(object : Any() {
                @ToJson
                fun toJson(writer: JsonWriter, o: CharSequence?) {
                    writer.value(o.toString())
                }

                @FromJson
                fun fromJson(reader: JsonReader): CharSequence? {
                    return reader.nextString()
                }
            })
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://$HOST/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val newBuilder = chain.request().newBuilder()
                        for (entry in headers) {
                            newBuilder.addHeader(entry.key, entry.value)
                        }
                        chain.proceed(newBuilder.build())
                    }
                    .build()
            )
            .build()


        tiebaService = retrofit.create(TiebaService::class.java)


        loginInfo = SPUtils.getInstance("login_info")
        phoneInfo = SPUtils.getInstance("phone_info")

        val sb = StringBuilder()
        sb.append(AppUtils.getAppPackageName())
        sb.append("_preferences")
        preferences = SPUtils.getInstance(sb.toString())
        imei = phoneInfo.getString("imei", "")
        if (imei.isEmpty()) {
            imei = "352316052799040"
        }
        BDUSS = loginInfo.getString("BDUSS", "")
        uid = loginInfo.getString("ID", "")
        tbs = loginInfo.getString("tbs", "")
        val sb2 = StringBuilder()
        sb2.append(StringUtils.LF)
        sb2.append(preferences.getString("little_tail", ""))
        littleTail = sb2.toString()
        netType = LINK
        val sb3 = StringBuilder()
        sb3.append("wappc_")
        sb3.append(getTimestamp())
        sb3.append("_")
        sb3.append(floor(Math.random() * 1000.0))
        clientId = sb3.toString()
        if (clientId.isEmpty()) {
            clientId = UUID.randomUUID().toString().replace("-", "")
            loginInfo.put("client_id", clientId)
        }
        clientType = EMOJI
        clientVersion = "5.7.0"
        addClientVersion = "6.9.2.1"
        newClientVersion = "8.2.2"
    }

    override suspend fun searchForum(params: Map<String, String>) = tiebaService.searchForum(params)

    suspend fun searchForum(key: String): ForumSug {
        val hashMap = HashMap<String, String>()
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.newClientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["q"] = key
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return searchForum(hashMap)
    }

    override suspend fun searchpost(params: Map<String, String>) = tiebaService.searchpost(params)

    suspend fun searchpost(pageNo: String, key: String): SearchPost {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.newClientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["pn"] = pageNo
        hashMap["rn"] = "25"
        hashMap["st_type"] = "search_post"
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["word"] = key
        hashMap["sign"] = calsign(hashMap)
        return searchpost(hashMap)
    }

    override suspend fun msign(params: Map<String, String>) = tiebaService.msign(params)

    suspend fun msign(forumIds: String): Msign {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["forum_ids"] = forumIds
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["user_id"] = this.uid
        hashMap["sign"] = calsign(hashMap)
        return msign(hashMap)
            .apply {
                if (error.errno != ERROR_CODE_SUCCESS) {
                    throw ApiErrorException("${error.usermsg}\n$signNotice", error.errno.toInt())
                }
            }
    }

    override suspend fun getforumlist(params: Map<String, String>) =
        tiebaService.getforumlist(params)

    suspend fun getforumlist(): GetForumList {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["user_id"] = this.uid
        hashMap["sign"] = calsign(hashMap)
        return getforumlist(hashMap)
    }

    override suspend fun likedForum(params: Map<String, String>) =
        tiebaService.likedForum(params)

    suspend fun likedForum(friendUid: String, page: Int): LikedForum {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["is_guest"] = BOOLEAN_TRUE
        if (friendUid.isNotEmpty()) {
            hashMap["friend_uid"] = friendUid
        }
        hashMap["page_no"] = page.toString()
        hashMap["page_size"] = RANGE_NUMBER.toString()
        hashMap["uid"] = this.uid
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)

        return likedForum(hashMap)
    }

    override suspend fun userFollow(params: Map<String, String>) =
        tiebaService.userFollow(params)

    suspend fun userFollow(portrait: String): FollowResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["portrait"] = portrait
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)

        return userFollow(hashMap)
            .apply {
                if (errorCode != ERROR_CODE_SUCCESS) {
                    throw ApiErrorException(errorMsg.orEmpty("关注失败"), errorCode.toInt())
                }
            }
    }

    override suspend fun unFollow(params: Map<String, String>) =
        tiebaService.unFollow(params)

    suspend fun unFollow(portrait: String): FollowResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["portrait"] = portrait
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)

        return unFollow(hashMap).apply {
            if (errorCode != ERROR_CODE_SUCCESS) {
                throw ApiErrorException(errorMsg, errorCode.toInt())
            }
        }
    }

    override suspend fun followList(params: Map<String, String>) = tiebaService.followList(params)

    suspend fun mutualFollowList(uid: String, pageNum: Int) =
        followList(uid, pageNum, 1)

    suspend fun followList(uid: String, pageNum: Int, tab: Int = 0): FollowList {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["pn"] = pageNum.toString()
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["tab"] = tab.toString()
        if (uid.isNotEmpty()) {
            hashMap["uid"] = uid
        }
        hashMap["sign"] = calsign(hashMap)
        return followList(hashMap)
    }

    override suspend fun follows(params: Map<String, String>) =
        tiebaService.follows(params)

    suspend fun follows(uid: String, pn: String): Follows {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["is_guest"] = BOOLEAN_TRUE
        hashMap["uid"] = uid
        hashMap["pn"] = pn
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)

        return follows(hashMap)
    }

    override suspend fun fans(params: Map<String, String>) =
        tiebaService.fans(params)

    suspend fun fans(uid: String, pn: String): Fans {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["is_guest"] = BOOLEAN_TRUE
        if (uid.isNotEmpty()) {
            hashMap["uid"] = uid
        }
        hashMap["pn"] = pn
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)

        return fans(hashMap)
    }

    override suspend fun threadstore(params: Map<String, String>) = tiebaService.threadstore(params)

    suspend fun threadstore(offset: Int, userID: String): ThreadStore {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.newClientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["offset"] = offset.toString()
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["user_id"] = userID
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return threadstore(hashMap)
    }

    override suspend fun profile(params: Map<String, String>) = tiebaService.profile(params)

    suspend fun profile(pageNum: String = "1"): Profile {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["need_post_count"] = BOOLEAN_TRUE
        hashMap["net_type"] = this.netType
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["uid"] = this.uid
        hashMap["pn"] = pageNum
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["sign"] = calsign(hashMap)
        return profile(hashMap)
    }

    override suspend fun friendProfile(params: Map<String, String>) =
        tiebaService.friendProfile(params)

    suspend fun friendProfile(friendUid: String, pageNum: String = "1"): Profile {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = "6.0.0"
        hashMap["_phone_imei"] = imei
        hashMap["from"] = "tieba"
        hashMap["need_post_count"] = BOOLEAN_TRUE
        hashMap["net_type"] = netType
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["uid"] = uid
        hashMap["pn"] = pageNum
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["is_guest"] = BOOLEAN_TRUE
        hashMap["friend_uid"] = friendUid
        hashMap["sign"] = calsign(hashMap)
        return friendProfile(hashMap)
    }

    override suspend fun msg(params: Map<String, String>) = tiebaService.msg(params)

    suspend fun msg(): StatusResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = newClientVersion
        hashMap["_phone_imei"] = imei
        hashMap["bookmark"] = BOOLEAN_TRUE
        hashMap["from"] = "tieba"
        hashMap["net_type"] = netType
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return msg(hashMap)
    }

    override suspend fun sign(params: Map<String, String>) = tiebaService.sign(params)

    suspend fun sign(name: String): Sign {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = "6.1.0"
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["kw"] = name
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return sign(hashMap)
            .apply {
                if (errorCode != ERROR_CODE_SUCCESS) {
                    throw ApiErrorException(errorMsg, errorCode.toInt())
                }
            }
    }

    override suspend fun likeForum(params: Map<String, String>) = tiebaService.likeForum(params)

    suspend fun likeForum(fid: String, kw: String): StatusResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = "6.6.0"
        hashMap["_phone_imei"] = this.imei
        hashMap["fid"] = fid
        hashMap["from"] = "tieba"
        hashMap["kw"] = kw
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return likeForum(hashMap)
    }

    override suspend fun unlikeForum(params: Map<String, String>) = tiebaService.unlikeForum(params)

    suspend fun unlikeForum(fid: String, kw: String): StatusResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = "6.6.0"
        hashMap["_phone_imei"] = this.imei
        hashMap["fid"] = fid
        hashMap["from"] = "tieba"
        hashMap["kw"] = kw
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return unlikeForum(hashMap)
    }

    override suspend fun forumPage(params: Map<String, String>) = tiebaService.forumPage(params)

    suspend fun forumPage(name: String, page: Int = 1, isGood: Boolean = false): ForumPage {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        if (isGood) {
            hashMap["is_good"] = BOOLEAN_TRUE
        }
        hashMap["kw"] = name
        hashMap["net_type"] = this.netType
        hashMap["q_type"] = "2"
        hashMap["pn"] = page.toString()
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["scr_dip"] = BOOLEAN_FALSE
        hashMap["scr_h"] = BOOLEAN_FALSE
        hashMap["scr_w"] = BOOLEAN_FALSE
        hashMap["st_type"] = "tb_forumlist"
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["with_group"] = BOOLEAN_FALSE
        hashMap["sign"] = calsign(hashMap)
        return forumPage(hashMap)
            .apply {
                if (errorCode != ERROR_CODE_SUCCESS) {
                    throw throw ApiErrorException(errorMsg, errorCode.toInt())
                }
            }
    }

    override suspend fun forumRecommend(@FieldMap params: Map<String, String>) =
        tiebaService.forumRecommend(params)

    suspend fun forumRecommend(): ForumRecommend {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = clientVersion
        hashMap["_phone_imei"] = imei
        hashMap["from"] = "tieba"
        hashMap["like_forum"] = BOOLEAN_TRUE
        hashMap["net_type"] = netType
        hashMap["recommend"] = BOOLEAN_FALSE
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["topic"] = BOOLEAN_FALSE
        hashMap["sign"] = calsign(hashMap)
        return forumRecommend(hashMap)
    }

    override suspend fun threadPage(params: Map<String, String>) =
        tiebaService.threadPage(params)

    suspend fun threadPage(
        threadId: String,
        pid: String? = null,
        lzOnly: Boolean = false,
        reverse: Boolean = false,
        mark: String = BOOLEAN_FALSE,
        page: Int? = null
    ): ThreadPage {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = "6.2.2"
        hashMap["_phone_imei"] = this.imei
        hashMap["back"] = BOOLEAN_FALSE
        hashMap["banner"] = BOOLEAN_FALSE
        hashMap["from"] = "tieba"
        hashMap["kz"] = threadId
        if (lzOnly) {
            hashMap["lz"] = BOOLEAN_TRUE
        }
        if (reverse) {
            // hashMap["last"] = BOOLEAN_TRUE
            hashMap["r"] = BOOLEAN_TRUE
        }
        // 正序 0 list ;1 pid后的list(包括pid)
        // 倒序 0 pid 前的list ;1 pid后的list(包括pid)
        hashMap["mark"] = mark
        hashMap["net_type"] = netType
        if (!pid.isNullOrEmpty()) {
            hashMap["pid"] = pid
        }
        page?.run {
            hashMap["pn"] = this.toString()
        }
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["q_type"] = "2"
        hashMap["st_type"] = if (mark == BOOLEAN_TRUE) "store_thread" else "tb_frslist"
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["with_floor"] = BOOLEAN_TRUE
        hashMap["sign"] = calsign(hashMap)
        return threadPage(hashMap)
            .apply {
                if (errorCode != ERROR_CODE_SUCCESS) {
                    throw throw ApiErrorException(errorMsg, errorCode.toInt())
                }
            }
    }

    override suspend fun subFloor(params: Map<String, String>) = tiebaService.subFloor(params)

    suspend fun subFloor(
        threadId: String,
        pid: String = "",
        spid: String = "",
        pageNum: String = "1"
    ): FloorPage {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = "6.6.0"
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["kz"] = threadId
        hashMap["net_type"] = this.netType
        if (pid.isNotEmpty()) {
            hashMap["pid"] = pid
        }
        hashMap["pn"] = pageNum
        hashMap["rn"] = RANGE_NUMBER.toString()
        if (spid.isNotEmpty()) {
            hashMap["spid"] = spid
        }
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return subFloor(hashMap)
    }

    suspend fun rmStore(tid: String): StatusResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.newClientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["tid"] = tid
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return rmStore(hashMap)
            .apply {
                if (errorCode != ERROR_CODE_SUCCESS) {
                    throw ApiErrorException(errorMsg, errorCode.toInt())
                }
            }
    }

    override suspend fun rmStore(@FieldMap params: Map<String, String>) =
        tiebaService.rmStore(params)

    override suspend fun addStore(@FieldMap params: Map<String, String>) =
        tiebaService.addStore(params)

    suspend fun addStore(
        tid: String,
        pid: String,
        lzOnly: Boolean,
        reverse: Boolean
    ): StatusResponse {
        val dataBeanX = DataDTO(
            pid,
            when {
                lzOnly && reverse -> MARK_STATE.SINGLE_REVERSE.value
                lzOnly && !reverse -> MARK_STATE.SINGLE_NORMAL.value
                reverse -> MARK_STATE.REVERSE.value
                !reverse -> MARK_STATE.NORMAL.value
                else -> MARK_STATE.NORMAL.value
            },
            tid
        )
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.newClientVersion
        hashMap["_phone_imei"] = this.imei


        hashMap["data"] = moshi.adapter<List<DataDTO>>(
            Types.newParameterizedType(
                List::class.java,
                DataDTO::class.java
            )
        ).toJson(listOf(dataBeanX))
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["tbs"] = this.tbs
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return addStore(hashMap)
            .apply {
                if (errorCode != ERROR_CODE_SUCCESS) {
                    throw ApiErrorException(errorMsg, errorCode.toInt())
                }
            }
    }

    override suspend fun addThread(@FieldMap params: Map<String, String>) =
        tiebaService.addThread(params)

    suspend fun addThread(
        str: String,
        str2: String,
        str3: String,
        str4: String,
        str5: String,
        str6: String
    ): StatusResponse {
        var str2 = str2
        if (littleTail.isNotEmpty()) {
            str2 = str2 + StringUtils.LF + littleTail
        }
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = addClientVersion
        hashMap["_phone_imei"] = imei
        hashMap["anonymous"] = BOOLEAN_TRUE
        hashMap["content"] = str2
        hashMap["fid"] = str4
        hashMap["from"] = "mini_baidu_appstore"
        hashMap["kw"] = str3
        hashMap["subapp_type"] = "mini"
        hashMap["tbs"] = tbs
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["title"] = str
        Log.e("vcode_md5", str6)
        if (str6.isNotEmpty()) {
            hashMap["vcode"] = str5
            hashMap["vcode_md5"] = str6
        }
        hashMap["versioncode"] = "101253632"
        hashMap["sign"] = calsign(hashMap)
        return addThread(hashMap)
    }

    override suspend fun addReply(@FieldMap params: Map<String, String>) =
        tiebaService.addReply(params)

    suspend fun addReply(
        str: String,
        str2: String,
        str3: String,
        str4: String,
        str5: String,
        str6: String
    ): StatusResponse {
        var str = str
        if (littleTail.length > 0) {
            str = str + StringUtils.LF + littleTail
        }
        val hashMap = HashMap<String, String>()

        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = addClientVersion
        hashMap["_phone_imei"] = imei
        hashMap["anonymous"] = BOOLEAN_TRUE
        hashMap["content"] = str
        hashMap["fid"] = str3
        hashMap["from"] = "tieba"
        hashMap["kw"] = str2
        hashMap["net_type"] = netType
        hashMap["tbs"] = tbs
        hashMap["tid"] = str4
        hashMap["timestamp"] = getTimestamp().toString()
        Log.e("vcode_md5", str6)
        if (!str6.isEmpty()) {
            Log.e("vcode_md5", "come in")
            hashMap["vcode"] = str5
            hashMap["vcode_md5"] = str6
        }
        hashMap["sign"] = calsign(hashMap)

        return addReply(hashMap)
    }

    override suspend fun addReply2Someone(@FieldMap params: Map<String, String>) =
        tiebaService.addReply2Someone(params)

    suspend fun addReply2Someone(
        str: String,
        str2: String,
        str3: String,
        str4: String,
        str5: String,
        str6: String,
        str7: String,
        str8: String
    ): StatusResponse {
        var str = str
        if (littleTail.length > 0) {
            str = str + StringUtils.LF + littleTail
        }
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = addClientVersion
        hashMap["_phone_imei"] = imei
        hashMap["anonymous"] = BOOLEAN_TRUE
        hashMap["content"] = str
        hashMap["fid"] = str3
        hashMap["floor_num"] = str4
        hashMap["from"] = "tieba"
        hashMap["kw"] = str2
        hashMap["net_type"] = netType
        hashMap["quote_id"] = str5
        hashMap["tbs"] = tbs
        hashMap["tid"] = str6
        hashMap["timestamp"] = getTimestamp().toString()
        Log.e("vcode_md5", str8)
        if (!str8.isEmpty()) {
            Log.e("vcode_md5", "come in")
            hashMap["vcode"] = str7
            hashMap["vcode_md5"] = str8
        }
        hashMap["sign"] = calsign(hashMap)

        return addReply2Someone(hashMap)
    }

    suspend fun upload(file: File, i: Int): String {
        val create: RequestBody =
            RequestBody.create(MediaType.parse("application/octet-stream"), file)
        return OkHttpClient()
            .newCall(
                Request.Builder()
                    .post(
                        MultipartBody.Builder().setType(MultipartBody.FORM).addPart(
                            Headers.of("Content-Disposition", "form-data; name=BDUSS"),
                            RequestBody.create(null as MediaType?, BDUSS)
                        )
                            .addPart(
                                Headers.of(
                                    "Content-Disposition",
                                    "form-data; name=pic; filename=pic; filename*=utf-8''pic"
                                ), create
                            )
                            .build()
                    )
                    .url("http://c.tieba.baidu.com/c/c/img/upload").headers(Headers.of(headers))
                    .build()
            )
            .execute()
            .body()
            ?.string() + "`" + i
    }

    override suspend fun replyme(@FieldMap params: Map<String, String>) =
        tiebaService.replyme(params)

    suspend fun replyme(str: String): StatusResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = "7.7.2"
        hashMap["_phone_imei"] = imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = netType
        hashMap["pn"] = str
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return replyme(hashMap)
    }

    override suspend fun atme(@FieldMap params: Map<String, String>) =
        tiebaService.atme(params)

    suspend fun atme(str: String): StatusResponse {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = "7.7.2"
        hashMap["_phone_imei"] = imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = netType
        hashMap["pn"] = str
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return atme(hashMap)
    }

    override suspend fun userPosts(@FieldMap params: Map<String, String>) =
        tiebaService.userPosts(params)

    suspend fun userPosts(
        uid: String,
        pn: String
    ): UserPost {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = newClientVersion
        hashMap["_phone_imei"] = imei
        hashMap["from"] = "tieba"
        hashMap["is_thread"] = BOOLEAN_TRUE
        hashMap["need_content"] = BOOLEAN_TRUE
        hashMap["net_type"] = netType
        hashMap["pn"] = pn
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["uid"] = uid
        hashMap["sign"] = calsign(hashMap)

        return userPosts(hashMap)
    }

    override suspend fun feed(@FieldMap params: Map<String, String>) =
        tiebaService.feed(params)

    suspend fun feed(page: String): FeedThread {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = newClientVersion
        hashMap["_phone_imei"] = imei
        hashMap["from"] = "tieba"
        hashMap["is_thread"] = BOOLEAN_TRUE
        hashMap["need_content"] = BOOLEAN_TRUE
        hashMap["net_type"] = netType
        hashMap["pn"] = page
        hashMap["q_type"] = "2"
        hashMap["rn"] = "20"
        hashMap["timestamp"] = getTimestamp().toString()
        hashMap["uid"] = uid
        hashMap["sign"] = calsign(hashMap)
        return feed(hashMap)
    }

    private fun calsign(map: Map<String, String>): String {
        val sb = StringBuilder()
        for ((key, value) in TreeMap(map)) {
            sb.append(key).append("=").append(value)
        }
        sb.append("tiebaclient!!!")
        return StringUtil.md54(sb.toString())
    }

    fun reset() {
        val loginInfo = SPUtils.getInstance("login_info")
        tbs = loginInfo.getString("tbs")
    }
}


