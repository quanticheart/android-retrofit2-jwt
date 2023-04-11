package com.quanticheart.jwt.core

import okhttp3.Authenticator
import okhttp3.Interceptor

//
// Created by Jonn Alves on 05/04/23.
//
interface Config {
    val baseUrl: String
    val headers: HashMap<String, String>?
    val authenticator: Authenticator?
    val interceptors: List<Interceptor>?
    val timeout: Long?
}