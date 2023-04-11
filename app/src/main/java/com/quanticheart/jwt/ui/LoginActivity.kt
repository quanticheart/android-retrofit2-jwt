package com.quanticheart.jwt.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.quanticheart.jwt.CoroutinesErrorHandler
import com.quanticheart.jwt.R
import com.quanticheart.jwt.core.models.ApiResponse
import com.quanticheart.jwt.core.requests.Auth
import com.quanticheart.jwt.ui.viewModel.AuthViewModel
import com.quanticheart.jwt.ui.viewModel.TokenViewModel
import dagger.hilt.android.AndroidEntryPoint

//
// Created by Jonn Alves on 04/04/23.
//
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()
    private val tokenViewModel: TokenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginTV = findViewById<TextView>(R.id.loginTV)

        tokenViewModel.token.observe(this) { token ->
            if (token != null) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        viewModel.loginResponse.observe(this) {
            when (it) {
                is ApiResponse.Failure -> loginTV.text = it.errorMessage
                is ApiResponse.Loading -> loginTV.text = "Loading"
                is ApiResponse.Success -> {
                    tokenViewModel.saveToken(it.data.data.token)
                }
            }
        }

        findViewById<Button>(R.id.loginButton).setOnClickListener {
            viewModel.login(
                Auth("test@test.com", "@!123456"),
                object : CoroutinesErrorHandler {
                    override fun onError(message: String) {
                        loginTV.text = "Error! $message"
                    }
                }
            )
        }
    }
}