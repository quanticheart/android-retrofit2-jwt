package com.quanticheart.jwt.repository

import com.quanticheart.jwt.core.extentions.request
import com.quanticheart.jwt.core.requests.Auth
import javax.inject.Inject

//
// Created by Jonn Alves on 04/04/23.
//
class AuthRepository @Inject constructor(private val authApiService: AuthApiService) {
    fun login(auth: Auth) = request {
        authApiService.login(auth)
    }
}