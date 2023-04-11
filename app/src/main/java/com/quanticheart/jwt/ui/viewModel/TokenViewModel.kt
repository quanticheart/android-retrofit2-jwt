package com.quanticheart.jwt.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quanticheart.jwt.core.TokenManager
import com.quanticheart.jwt.core.extentions.dispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//
// Created by Jonn Alves on 04/04/23.
//
@HiltViewModel
class TokenViewModel @Inject constructor(private val tokenManager: TokenManager) : ViewModel() {

    val token = MutableLiveData<String?>()

    init {
        dispatcher {
            tokenManager.getToken().collect {
                withContext(Dispatchers.Main) {
                    token.value = it
                }
            }
        }
    }

    fun saveToken(token: String) {
        dispatcher {
            tokenManager.saveToken(token)
        }
    }

    fun deleteToken() {
        dispatcher {
            tokenManager.deleteToken()
        }
    }
}