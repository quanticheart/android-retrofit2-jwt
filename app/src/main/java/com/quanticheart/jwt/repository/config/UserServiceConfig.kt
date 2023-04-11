package com.quanticheart.jwt.repository.config

import com.quanticheart.jwt.core.ConnectionConfig
import com.quanticheart.jwt.core.TokenManager
import com.quanticheart.jwt.core.authenticators.AuthAuthenticator
import com.quanticheart.jwt.core.interceptors.AuthInterceptor
import okhttp3.Authenticator
import okhttp3.Interceptor

//
// Created by Jonn Alves on 06/04/23.
//
class UserServiceConfig(private val tokenManager: TokenManager) : ConnectionConfig() {
    override val baseUrl: String
        get() = "https://api.test.com/"

    override val authenticator: Authenticator
        get() = AuthAuthenticator(tokenManager)

    override val interceptors: List<Interceptor>
        get() = arrayListOf(AuthInterceptor(tokenManager))
}