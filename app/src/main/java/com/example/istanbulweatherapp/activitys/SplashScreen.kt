package com.example.istanbulweatherapp.activitys

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.istanbulweatherapp.R


class SplashScreen : AppCompatActivity() {

    private val splashTimeOut: Long = 5000
    private lateinit var connectivityManager: ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        Handler().postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}

