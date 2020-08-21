package com.saniou.santieba.model.api.reqeust

import android.os.Build
import android.webkit.WebSettings
import com.blankj.utilcode.util.PhoneUtils
import com.blankj.utilcode.util.Utils
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.model.UIDUtil
import com.saniou.santieba.model.api.interceptors.AddCookieInterceptor
import com.saniou.santieba.model.api.interceptors.CommonHeaderInterceptor
import com.saniou.santieba.model.api.interceptors.CommonParamInterceptor
import com.saniou.santieba.model.api.interceptors.ForceLoginInterceptor
import com.saniou.santieba.model.api.interceptors.SortAndSignInterceptor
import com.saniou.santieba.model.api.interceptors.StParamInterceptor
import com.saniou.santieba.model.api.interfaces.MiniTiebaApi
import com.saniou.santieba.model.api.interfaces.OfficialTiebaApi
import com.saniou.santieba.model.api.interfaces.WebTiebaApi
import com.saniou.santieba.model.api.retrofit.interfaces.NewTiebaApi
import com.sanniou.support.moshi.EmptyListToNull
import com.sanniou.support.moshi.IgnoreString2Object
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object TiebaRetrofit {
    private val initTime = System.currentTimeMillis()
    private val clientId = "wappc_${initTime}_${Math.round(Math.random() * 1000).toInt()}"
    private val stParamInterceptor = StParamInterceptor()
    private val connectionPool = ConnectionPool()

    val moshi = Moshi.Builder()
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

    private val defaultCommonParamInterceptor = CommonParamInterceptor(
        Param.BDUSS to { AccountUtil.getBduss() },
        Param.CLIENT_ID to { clientId },
        Param.CLIENT_TYPE to { "2" },
        Param.OS_VERSION to { Build.VERSION.SDK_INT.toString() },
        Param.MODEL to { Build.MODEL },
        Param.NET_TYPE to { "1" },
        Param.PHONE_IMEI to { PhoneUtils.getIMEI() },
        Param.TIMESTAMP to { System.currentTimeMillis().toString() }
    )

    private val defaultCommonHeaderInterceptor =
        CommonHeaderInterceptor(
            Header.COOKIE to { "ka=open" },
            Header.PRAGMA to { "no-cache" }
        )
    private val sortAndSignInterceptor = SortAndSignInterceptor("tiebaclient!!!")

    val NEW_TIEBA_API: NewTiebaApi by lazy {
        createAPI<NewTiebaApi>(
            "http://c.tieba.baidu.com/",
            defaultCommonHeaderInterceptor,
            CommonHeaderInterceptor(
                Header.USER_AGENT to { "bdtb for Android 8.2.2" },
                Header.CUID to { UIDUtil.getFinalCUID() }
            ),
            defaultCommonParamInterceptor,
            stParamInterceptor,
            CommonParamInterceptor(
                Param.CUID to { UIDUtil.getFinalCUID() },
                Param.FROM to { "baidu_appstore" },
                Param.CLIENT_VERSION to { "8.2.2" }
            ))
    }

    val WEB_TIEBA_API: WebTiebaApi by lazy {
        createAPI<WebTiebaApi>(
            "https://tieba.baidu.com/",
            CommonHeaderInterceptor(
                Header.HOST to { "tieba.baidu.com" },
                Header.USER_AGENT to { WebSettings.getDefaultUserAgent(Utils.getApp()) }
            ),
            AddCookieInterceptor)
    }

    val MINI_TIEBA_API: MiniTiebaApi by lazy {
        createAPI<MiniTiebaApi>(
            "http://c.tieba.baidu.com/",
            defaultCommonHeaderInterceptor,
            CommonHeaderInterceptor(
                Header.USER_AGENT to { "bdtb for Android 7.2.0.0" },
                Header.CUID to { UIDUtil.getFinalCUID() },
                Header.CUID_GALAXY2 to { UIDUtil.getFinalCUID() }
            ),
            defaultCommonParamInterceptor,
            stParamInterceptor,
            CommonParamInterceptor(
                Param.CUID to { UIDUtil.getFinalCUID() },
                Param.CUID_GALAXY2 to { UIDUtil.getFinalCUID() },
                Param.FROM to { "1021636m" },
                Param.CLIENT_VERSION to { "7.2.0.0" },
                Param.SUBAPP_TYPE to { "mini" }
            ))
    }

    val OFFICIAL_TIEBA_API: OfficialTiebaApi by lazy {
        createAPI<OfficialTiebaApi>(
            "http://c.tieba.baidu.com/",
            defaultCommonHeaderInterceptor,
            CommonHeaderInterceptor(
                Header.USER_AGENT to { "bdtb for Android 9.9.8.32" },
                Header.CUID to { UIDUtil.getNewCUID() },
                Header.CUID_GALAXY2 to { UIDUtil.getFinalCUID() },
                Header.CUID_GID to { "" }
            ),
            defaultCommonParamInterceptor,
            stParamInterceptor,
            CommonParamInterceptor(
                Param.CUID to { UIDUtil.getNewCUID() },
                Param.CUID_GALAXY2 to { UIDUtil.getFinalCUID() },
                Param.CUID_GID to { "" },
                Param.FROM to { "tieba" },
                Param.CLIENT_VERSION to { "9.9.8.32" }
            ))
    }

    private inline fun <reified T : Any> createAPI(
        baseUrl: String,
        vararg interceptors: Interceptor
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(OkHttpClient.Builder().apply {
            interceptors.forEach {
                addInterceptor(it)
            }
            addInterceptor(sortAndSignInterceptor)
            addInterceptor(ForceLoginInterceptor)
            connectionPool(connectionPool)
        }.build())
        .build()
        .create(T::class.java)
}