package com.quanticheart.jwt.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.quanticheart.jwt.BaseViewModel
import com.quanticheart.jwt.CoroutinesErrorHandler
import com.quanticheart.jwt.core.models.ApiResponse
import com.quanticheart.jwt.repository.MainRepository
import com.quanticheart.jwt.repository.response.UserInfoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//
// Created by Jonn Alves on 04/04/23.
//
@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    BaseViewModel() {

    private val _userInfoResponse = MutableLiveData<ApiResponse<UserInfoResponse>>()
    val userInfoResponse = _userInfoResponse

    fun getUserInfo(coroutinesErrorHandler: CoroutinesErrorHandler) =
        baseRequest(_userInfoResponse, coroutinesErrorHandler) {
            mainRepository.getUserInfo()
        }
}