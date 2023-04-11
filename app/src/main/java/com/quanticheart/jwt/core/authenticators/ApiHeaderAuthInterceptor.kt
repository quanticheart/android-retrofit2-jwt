package com.quanticheart.jwt.core.authenticators

import com.quanticheart.jwt.core.ApiDataManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

//
// Created by Jonn Alves on 11/04/23.
//
class ApiHeaderAuthInterceptor(private val apiManager: ApiDataManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val newRequest: Request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("X-Application", apiManager.getXToken())
            .addHeader("X-Authentication", apiManager.getXAuth())
            .addHeader("X-Language", apiManager.getSysLang())
            .method(request.method, request.body)
            .build()
        return chain.proceed(newRequest)
    }
}