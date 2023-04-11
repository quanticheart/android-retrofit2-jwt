package com.quanticheart.jwt.repository

import com.quanticheart.jwt.core.extentions.request
import javax.inject.Inject

//
// Created by Jonn Alves on 04/04/23.
//
class MainRepository @Inject constructor(private val mainApiService: MainApiService) {
    fun getUserInfo() = request {
        mainApiService.getUserInfo()
    }
}