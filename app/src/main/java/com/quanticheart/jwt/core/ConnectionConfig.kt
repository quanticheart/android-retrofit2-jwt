package com.quanticheart.jwt.core

import okhttp3.Authenticator
import okhttp3.Interceptor

//
// Created by Jonn Alves on 06/04/23.
//
abstract class ConnectionConfig : Config {
    override val headers: HashMap<String, String>?
        get() = null
    override val authenticator: Authenticator?
        get() = null
    override val interceptors: List<Interceptor>?
        get() = null
    override val timeout: Long?
        get() = null
}