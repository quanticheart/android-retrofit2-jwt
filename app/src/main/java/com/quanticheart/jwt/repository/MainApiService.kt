package com.quanticheart.jwt.repository

import com.quanticheart.jwt.repository.response.UserInfoResponse
import retrofit2.Response
import retrofit2.http.GET

//
// Created by Jonn Alves on 04/04/23.
//
interface MainApiService {
    @GET("auth/session")
    suspend fun getUserInfo(): Response<UserInfoResponse>
}