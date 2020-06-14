package com.saniou.santieba.model.api.interceptors

import com.blankj.utilcode.util.Utils
import com.saniou.santieba.model.api.reqeust.AccountUtil
import com.saniou.santieba.model.api.reqeust.Header
import okhttp3.Interceptor
import okhttp3.Response

object AddCookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var headers = request.headers
        val httpUrl = request.url
        val body = request.body

        var addCookie = true
        val addCookieHeader = headers[Header.ADD_COOKIE]
        if (addCookieHeader != null) {
            if (addCookieHeader == Header.ADD_COOKIE_FALSE) addCookie = false
            headers = headers.newBuilder()
                .removeAll(Header.ADD_COOKIE)
                .build()
        }

        if (addCookie) {
            headers = headers.newBuilder()
                .removeAll(Header.COOKIE)
                .add(Header.COOKIE, AccountUtil.getCookie(Utils.getApp()) ?: "")
                .build()
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