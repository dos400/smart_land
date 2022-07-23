package uz.hamroev.smartland.retrofitWeather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClientWeather {

    val BASE_URL = "https://api.openweathermap.org/"


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object

    val service = retrofit.create(ApiServiceWeather::class.java)
}