package com.quanticheart.jwt.repository.config

import com.quanticheart.jwt.core.ConnectionConfig

//
// Created by Jonn Alves on 06/04/23.
//
class AuthServiceConfig : ConnectionConfig() {
    override val baseUrl: String
        get() = "https://api.test.com/"
}