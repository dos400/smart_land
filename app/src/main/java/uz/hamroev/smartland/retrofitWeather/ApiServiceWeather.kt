package uz.hamroev.smartland.retrofitWeather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.hamroev.smartland.retrofitWeather.modelWeather.Weather

interface ApiServiceWeather {


    @GET("/data/2.5/weather?&appid=b7bb70d38b534e5071f080170ea1478a")
    fun getWeatherByLonAndLot(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String
    ): Call<Weather>


}