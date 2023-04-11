package com.quanticheart.jwt.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.quanticheart.jwt.BaseViewModel
import com.quanticheart.jwt.CoroutinesErrorHandler
import com.quanticheart.jwt.core.models.ApiResponse
import com.quanticheart.jwt.core.requests.Auth
import com.quanticheart.jwt.core.responses.LoginResponse
import com.quanticheart.jwt.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//
// Created by Jonn Alves on 04/04/23.
//
@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) :
    BaseViewModel() {

    private val _loginResponse = MutableLiveData<ApiResponse<LoginResponse>>()
    val loginResponse = _loginResponse

    fun login(auth: Auth, coroutinesErrorHandler: CoroutinesErrorHandler) =
        baseRequest(_loginResponse, coroutinesErrorHandler) {
            authRepository.login(auth)
        }
}