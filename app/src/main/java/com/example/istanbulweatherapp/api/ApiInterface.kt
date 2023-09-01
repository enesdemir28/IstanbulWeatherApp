package com.example.istanbulweatherapp.api



import com.example.istanbulweatherapp.models.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("forecast")
    fun getWeatherData(@Query("q") city : String,  @Query("appid") appid : String,
                       @Query("units") units : String): Call<Weather>
}
