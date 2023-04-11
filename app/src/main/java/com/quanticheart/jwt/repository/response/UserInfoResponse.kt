package com.quanticheart.jwt.repository.response

import com.google.gson.annotations.SerializedName

//
// Created by Jonn Alves on 04/04/23.
//
data class UserInfoResponse(
    @SerializedName("status")
    val status: Boolean = false,
    @SerializedName("msg")
    val msg: String = "",
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("data")
    val data: UserInfo,
)

data class UserInfo(
    @SerializedName("email")
    val email: String = "",
)