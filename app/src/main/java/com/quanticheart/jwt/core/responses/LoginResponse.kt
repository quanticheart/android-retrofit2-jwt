package com.quanticheart.jwt.core.responses

import com.google.gson.annotations.SerializedName

//
// Created by Jonn Alves on 04/04/23.
//
data class LoginResponse(
    @SerializedName("status")
    val status: Boolean = false,
    @SerializedName("msg")
    val msg: String = "",
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("data")
    val data: DataResponse,
)

data class DataResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("expire")
    val expire: Long
)