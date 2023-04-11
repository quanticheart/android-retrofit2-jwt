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
import com.quanticheart.jwt.ui.viewModel.MainViewModel
import com.quanticheart.jwt.ui.viewModel.TokenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val tokenViewModel: TokenViewModel by viewModels()

    private var token: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tokenViewModel.token.observe(this) { token ->
            this.token = token
            if (token == null) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        val mainTV = findViewById<TextView>(R.id.infoTV)
        viewModel.userInfoResponse.observe(this) {
            mainTV.text = when (it) {
                is ApiResponse.Failure -> "Code: ${it.code}, ${it.errorMessage}"
                ApiResponse.Loading -> "Loading"
                is ApiResponse.Success -> "ID: ${it.data.data.email}"
            }
        }

        findViewById<Button>(R.id.infoButton).setOnClickListener {
            viewModel.getUserInfo(object : CoroutinesErrorHandler {
                override fun onError(message: String) {
                    mainTV.text = "Error! $message"
                }
            })
        }

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            tokenViewModel.deleteToken()
        }
    }
}