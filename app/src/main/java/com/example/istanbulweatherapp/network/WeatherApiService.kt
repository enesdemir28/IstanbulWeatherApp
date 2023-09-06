package com.example.istanbulweatherapp.network

import android.util.Log
import android.widget.TextView
import com.example.istanbulweatherapp.api.ApiInterface
import com.example.istanbulweatherapp.models.Weather
import com.example.istanbulweatherapp.utils.Constants.BASE_URL

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiService {


    private var tv_temp: TextView? = null
    private var tv_city: TextView? = null
    private var tv_description: TextView? = null
    private var tv_windspeed: TextView? = null
    private var tv_humidity: TextView? = null
    private var tv_pressure: TextView? = null


    fun fetchWeatherData(tempTextView: TextView,cityTextView: TextView,descTextView: TextView, windTextView : TextView,
                         humidityTextView : TextView, pressureTextView : TextView) {
        tv_temp = tempTextView
        tv_city = cityTextView
        tv_description = descTextView
        tv_windspeed = windTextView
        tv_humidity = humidityTextView
        tv_pressure = pressureTextView

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val response = retrofit.getWeatherData("Istanbul", "bebdc0cb29b151b32602251f525739bb", "metric")

        response.enqueue(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null && responseBody.list.isNotEmpty()) {


                        tv_temp?.text = responseBody.list[0].main.temp.toString()
                        tv_city?.text = responseBody.city.name
                        tv_description?.text = responseBody.list[0].weather[0].description
                        tv_windspeed?.text = responseBody.list[0].wind.speed.toString()
                        tv_humidity?.text =  responseBody.list[0].main.humidity.toString()
                        tv_pressure?.text =  responseBody.list[0].main.pressure.toString()

                    } else {
                        Log.d("DATA", "API yanıtı boş veya veri yok.")
                    }
                } else {
                    Log.d("DATA", "API isteği başarısız: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("DATA", "API çağrısı başarısız: ${t.message}")
            }
        })
    }
}