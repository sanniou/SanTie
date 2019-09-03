package com.saniou.santieba.api

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.saniou.santieba.api.bean.*
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.constant.ThreadContentType
import com.saniou.santieba.utils.DateUtil
import com.saniou.santieba.utils.StringUtil
import com.sanniou.common.network.BaseRequest
import com.sanniou.common.network.CommonRetrofit
import com.sanniou.common.utilcode.util.AppUtils
import com.sanniou.common.utilcode.util.SPUtils
import io.reactivex.Observable
import org.apache.commons.lang3.StringUtils
import retrofit2.http.FieldMap
import java.util.*
import kotlin.collections.HashMap

object TiebaRequest : TiebaService, BaseRequest() {

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

    init {
        headers["Cookie"] = "ka=open"
        headers["net"] = ThreadContentType.IMAGE
        headers["User-Agent"] = "bdtb for Android 6.9.2.1"
        headers["Pragma"] = "no-cache"

        CommonRetrofit.setHttpClientHandler { builder ->
            builder.addInterceptor { chain ->
                val newBuilder = chain.request().newBuilder()
                for (entry in headers) {
                    newBuilder.addHeader(entry.key, entry.value)
                }
                chain.proceed(newBuilder.build())
            }
        }


        CommonRetrofit.setGsonHandler { builder ->
            builder.registerTypeAdapter(SubPostDetail::class.java, SubPostDetailConverter())
                .addDeserializationExclusionStrategy(createExclusion("pendant"))
                .addDeserializationExclusionStrategy(createExclusion("location"))
                .addDeserializationExclusionStrategy(createExclusion("signature"))
                .addDeserializationExclusionStrategy(createExclusion("pb_live"))
                .addDeserializationExclusionStrategy(createExclusion("ala_info"))
                .addDeserializationExclusionStrategy(createExclusion("add_post_list"))
                .addDeserializationExclusionStrategy(createExclusion("twzhibo_info"))
                .addDeserializationExclusionStrategy(createExclusion("spring_virtual_user"))
                .addDeserializationExclusionStrategy(createExclusion("window"))
                .addDeserializationExclusionStrategy(createExclusion("logid"))
                .addDeserializationExclusionStrategy(createExclusion("post_prefix"))
                .addDeserializationExclusionStrategy(createExclusion("theme_card"))
                .addDeserializationExclusionStrategy(createExclusion("banner"))
                .addDeserializationExclusionStrategy(createExclusion("zan"))
                .addDeserializationExclusionStrategy(createExclusion("iconinfo"))
                .addDeserializationExclusionStrategy(createExclusion("lbs_info"))
                .addDeserializationExclusionStrategy(createExclusion("new_user_info"))
                .addDeserializationExclusionStrategy(createExclusion("tb_vip"))
                .addDeserializationExclusionStrategy(createExclusion("god_data"))
                .addDeserializationExclusionStrategy(createExclusion("poll_info"))
                .addDeserializationExclusionStrategy(createExclusion("star_enter"))
                .addDeserializationExclusionStrategy(createExclusion("book_chapter"))
        }


        tiebaService = CommonRetrofit.getInstance().create(TiebaService::class.java)


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
        netType = ThreadContentType.LINK
        val sb3 = StringBuilder()
        sb3.append("wappc_")
        sb3.append(DateUtil.getTimestamp())
        sb3.append("_")
        sb3.append(Math.floor(Math.random() * 1000.0))
        clientId = sb3.toString()
        if (clientId.isEmpty()) {
            clientId = UUID.randomUUID().toString().replace("-", "")
            loginInfo.put("client_id", clientId)
        }
        clientType = ThreadContentType.EMOJI
        clientVersion = "5.7.0"
        addClientVersion = "6.9.2.1"
        newClientVersion = "8.2.2"
    }

    private fun createExclusion(str: String): ExclusionStrategy {
        return object : ExclusionStrategy {
            override fun shouldSkipClass(cls: Class<*>): Boolean {
                return false
            }

            override fun shouldSkipField(fieldAttributes: FieldAttributes): Boolean {
                return fieldAttributes.name == str
            }
        }
    }

    override fun msign(params: Map<String, String>) = tiebaService.msign(params)

    fun msing(forumIds: String): Observable<Objects> {
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
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["user_id"] = this.uid
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(msign(hashMap))
    }

    override fun getforumlist(params: Map<String, String>) = tiebaService.getforumlist(params)

    fun getforumlist(): Observable<ForumListP> {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["net_type"] = this.netType
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["user_id"] = this.uid
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(getforumlist(hashMap))
    }

    override fun profile(params: Map<String, String>) = tiebaService.profile(params)

    fun profile(): Observable<String> {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        hashMap["need_post_count"] = ThreadContentType.LINK
        hashMap["net_type"] = this.netType
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["uid"] = this.uid
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(profile(hashMap))
    }

    override fun sign(params: Map<String, String>) = tiebaService.sign(params)

    fun sign(name: String): Observable<Objects> {
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
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(sign(hashMap))
    }

    override fun postPage(params: Map<String, String>) = tiebaService.postPage(params)

    fun postPage(name: String, page: Int = 1, isGood: String = "0"): Observable<ThreadProfile> {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.clientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["from"] = "tieba"
        if (ThreadContentType.LINK == isGood) {
            hashMap["is_good"] = isGood
        }
        hashMap["kw"] = name
        hashMap["net_type"] = this.netType
        hashMap["pn"] = page.toString()
        hashMap["q_type"] = ThreadContentType.EMOJI
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["scr_dip"] = ThreadContentType.TEXT
        hashMap["scr_h"] = ThreadContentType.TEXT
        hashMap["scr_w"] = ThreadContentType.TEXT
        hashMap["st_type"] = "tb_forumlist"
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["with_group"] = ThreadContentType.TEXT
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(postPage(hashMap))
    }

    override fun getFavorite(@FieldMap params: Map<String, String>): Observable<Forum2> {
        return tiebaService.getFavorite(params)
    }

    fun getFavorite(): Observable<Forum2> {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = BDUSS
        hashMap["_client_id"] = clientId
        hashMap["_client_type"] = clientType
        hashMap["_client_version"] = clientVersion
        hashMap["_phone_imei"] = imei
        hashMap["from"] = "tieba"
        hashMap["like_forum"] = ThreadContentType.LINK
        hashMap["net_type"] = netType
        hashMap["recommend"] = ThreadContentType.TEXT
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["topic"] = ThreadContentType.TEXT
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(getFavorite(hashMap))
    }

    override fun threadDetail(params: Map<String, String>) = tiebaService.threadDetail(params)

    fun threadDetail(
        threadId: String,
        pid: String = "",
        lzOnly: Boolean = false,
        reverse: Boolean = false
    ): Observable<ThreadDetail> {
        val hashMap = HashMap<String, String>()
        hashMap["BDUSS"] = this.BDUSS
        hashMap["_client_id"] = this.clientId
        hashMap["_client_type"] = this.clientType
        hashMap["_client_version"] = this.newClientVersion
        hashMap["_phone_imei"] = this.imei
        hashMap["back"] = ThreadContentType.TEXT
        hashMap["floor_rn"] = ThreadContentType.IMAGE
        hashMap["from"] = "tieba"
        hashMap["kz"] = threadId
        if (lzOnly) {
            hashMap["lz"] = ThreadContentType.LINK
        }
        if (reverse) {
            hashMap["last"] = ThreadContentType.LINK
            hashMap["r"] = ThreadContentType.LINK
        }
        hashMap["mark"] = ThreadContentType.TEXT
        hashMap["net_type"] = netType
        if (pid.isNotEmpty()) {
            hashMap["pid"] = pid
        }
        hashMap["rn"] = RANGE_NUMBER.toString()
        hashMap["scr_dip"] = ThreadContentType.TEXT
        hashMap["scr_h"] = ThreadContentType.TEXT
        hashMap["scr_w"] = ThreadContentType.TEXT
        hashMap["st_type"] = "tb_frslist"
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["with_floor"] = ThreadContentType.LINK
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(threadDetail(hashMap))

    }

    override fun getSubFloor(params: Map<String, String>) = tiebaService.getSubFloor(params)

    fun getSubFloor(
        threadId: String,
        pid: String = "",
        spid: String = "",
        pageNum: String = "1"
    ): Observable<ThreadSubComment> {
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
        hashMap["timestamp"] = DateUtil.getTimestamp().toString()
        hashMap["sign"] = calsign(hashMap)
        return threadConfigWithoutMap(getSubFloor(hashMap))

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


