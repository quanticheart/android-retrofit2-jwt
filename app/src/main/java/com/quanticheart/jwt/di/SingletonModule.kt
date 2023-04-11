package com.quanticheart.jwt.di

import android.content.Context
import com.quanticheart.jwt.core.Connection
import com.quanticheart.jwt.core.TokenManager
import com.quanticheart.jwt.repository.AuthApiService
import com.quanticheart.jwt.repository.MainApiService
import com.quanticheart.jwt.repository.config.AuthServiceConfig
import com.quanticheart.jwt.repository.config.UserServiceConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//
// Created by Jonn Alves on 04/04/23.
//

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

    @Singleton
    @Provides
    fun provideAuthServiceConfig() = AuthServiceConfig()

    @Singleton
    @Provides
    fun provideUserServiceConfig(tokenManager: TokenManager) = UserServiceConfig(tokenManager)

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager =
        TokenManager(context)

    @Singleton
    @Provides
    fun provideAuthAPIService(config: AuthServiceConfig): AuthApiService =
        Connection(config).create()

    @Singleton
    @Provides
    fun provideMainAPIService(config: UserServiceConfig): MainApiService =
        Connection(config).create()

}