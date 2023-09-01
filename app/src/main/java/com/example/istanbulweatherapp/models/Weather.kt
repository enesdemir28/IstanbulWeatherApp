package com.example.istanbulweatherapp.models

data class Weather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<DT>,
    val message: Int
)