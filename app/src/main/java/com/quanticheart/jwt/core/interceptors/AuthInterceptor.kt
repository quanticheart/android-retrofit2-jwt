package com.quanticheart.jwt.core.interceptors

import com.quanticheart.jwt.core.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

//
// Created by Jonn Alves on 04/04/23.
//
class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            tokenManager.getToken().first()
        }
        val request = chain.request().newBuilder()
        token?.let {
            request.addHeader("user-token", "$it")
        }
        return chain.proceed(request.build())
    }
}