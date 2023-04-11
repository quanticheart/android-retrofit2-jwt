package com.quanticheart.jwt.core.requests

import com.google.gson.annotations.SerializedName

//
// Created by Jonn Alves on 04/04/23.
//
data class Auth(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)