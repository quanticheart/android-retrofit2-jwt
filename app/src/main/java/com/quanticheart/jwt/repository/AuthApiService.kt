package com.quanticheart.jwt.repository

import com.quanticheart.jwt.core.requests.Auth
import com.quanticheart.jwt.core.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

//
// Created by Jonn Alves on 04/04/23.
//
interface AuthApiService {
    @POST("auth/login")
    suspend fun login(@Body auth: Auth): Response<LoginResponse>
}