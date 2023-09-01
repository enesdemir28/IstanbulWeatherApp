package com.example.istanbulweatherapp.activitys

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

import com.example.istanbulweatherapp.R
import com.example.istanbulweatherapp.network.WeatherApiService


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtViewCity: TextView = findViewById(R.id.tv_city)
        val txtViewWeather: TextView = findViewById(R.id.tv_temp)
        val txtViewDesc: TextView = findViewById(R.id.tv_description)

        val weatherApiService = WeatherApiService()

        weatherApiService.fetchWeatherData(txtViewWeather,txtViewCity,txtViewDesc)


    }
}