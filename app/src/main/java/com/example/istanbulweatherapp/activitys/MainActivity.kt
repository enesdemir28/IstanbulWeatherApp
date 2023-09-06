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
        val txtViewWindSpeed: TextView = findViewById(R.id.tv_windspeed)
        val txtViewHumidity: TextView = findViewById(R.id.tv_humidity)
        val txtViewPressure: TextView = findViewById(R.id.tv_pressure)


        val weatherApiService = WeatherApiService()

        weatherApiService.fetchWeatherData(txtViewWeather,txtViewCity,txtViewDesc, txtViewWindSpeed,txtViewHumidity,txtViewPressure)


    }
}