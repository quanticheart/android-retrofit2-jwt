package com.quanticheart.jwt.core

import com.quanticheart.jwt.core.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

//
// Created by Jonn Alves on 04/04/23.
//
interface TokenService {
    @GET("auth/refresh")
    suspend fun refreshToken(@Header("user-token") token: String): Response<LoginResponse>
}