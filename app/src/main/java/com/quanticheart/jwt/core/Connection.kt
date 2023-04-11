package com.quanticheart.jwt.core

import com.quanticheart.jwt.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

//
// Created by Jonn Alves on 04/04/23.
//
class Connection @Inject constructor(val config: Config) {

    inline fun <reified T> create(): T {
        val client = OkHttpClient.Builder()
            .connectTimeout(config.timeout ?: 20, TimeUnit.SECONDS)
            .writeTimeout(config.timeout ?: 20, TimeUnit.SECONDS)
            .readTimeout(config.timeout ?: 30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            client.addInterceptor(interceptor)
        }

        config.headers?.let {
            client.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                it.forEach {
                    request.addHeader(it.key, it.value)
                }
                chain.proceed(request.build())
            }
        }

        config.interceptors?.let {
            it.forEach { interceptor -> client.addInterceptor(interceptor) }
        }

        config.authenticator?.let { client.authenticator(it) }

        val r = Retrofit.Builder()
            .baseUrl(config.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()

        return r.create(T::class.java)
    }
}
