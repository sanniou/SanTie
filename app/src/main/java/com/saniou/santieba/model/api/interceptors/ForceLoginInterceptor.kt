package com.saniou.santieba.model.api.interceptors

import com.blankj.utilcode.util.Utils
import com.saniou.santieba.model.api.reqeust.Error.ERROR_NOT_LOGGED_IN
import com.saniou.santieba.model.api.reqeust.Header
import com.saniou.santieba.model.api.reqeust.AccountUtil
import com.sanniou.support.exception.ApiErrorException
import okhttp3.Interceptor
import okhttp3.Response

object ForceLoginInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var headers = request.headers
        var httpUrl = request.url
        var body = request.body

        //是否强制登录
        var forceLogin = false
        val forceLoginHeader = headers[Header.FORCE_LOGIN]
        if (forceLoginHeader != null) {
            if (forceLoginHeader == Header.FORCE_LOGIN_TRUE) forceLogin = true
            headers = headers.newBuilder().removeAll(Header.FORCE_LOGIN).build()
        }

        if (forceLogin && !AccountUtil.isLoggedIn(Utils.getApp())) {
            throw ApiErrorException(ERROR_NOT_LOGGED_IN, "Not logged in.")
        }

        return chain.proceed(
            request.newBuilder()
                .headers(headers)
                .url(httpUrl)
                .method(request.method, body)
                .build()
        )
    }
}