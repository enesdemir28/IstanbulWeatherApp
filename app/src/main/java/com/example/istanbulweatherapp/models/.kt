package com.example.istanbulweatherapp.models

data class DT(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<WeatherX>,
    val wind: Wind
)