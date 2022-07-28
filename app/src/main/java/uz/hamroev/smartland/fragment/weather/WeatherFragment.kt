package uz.hamroev.smartland.fragment.weather

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.hamroev.smartland.R
import uz.hamroev.smartland.databinding.FragmentWeatherBinding
import uz.hamroev.smartland.retrofitWeather.ApiClientWeather
import uz.hamroev.smartland.retrofitWeather.modelWeather.Weather
import uz.hamroev.smartland.utils.gone
import uz.hamroev.smartland.utils.visible
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*


class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val TAG = "WeatherFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(layoutInflater, container, false)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }


        binding.main.gone()
        binding.progressLinear.visible()

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(binding.root.context)
        getLocationAddress()


        return binding.root
    }

    private fun getLocationAddress() {

        fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
            val location = task.result as Location

            if (location != null) {
                try {
                    val geocoder = Geocoder(requireContext(), Locale.getDefault())
                    val addresses: List<Address> = geocoder.getFromLocation(
                        location.latitude, location.longitude, 1
                    )
                    for (address in addresses) {
                        Log.d(
                            TAG, "getLocationAddress: " +
                                    "latitude = ${address.latitude} " +
                                    "longitude = ${address.longitude} " +
                                    "adminArea = ${address.adminArea} " +
                                    "countryName = ${address.countryName} " +
                                    "countryCode = ${address.countryCode} " +
                                    "subLocality = ${address.subLocality} " +
                                    "extras = ${address.extras} " +
                                    "getAddressLine = ${address.getAddressLine(0)} " +
                                    "url = ${address.url} " +
                                    "latitude = ${address.latitude}"
                        )
                        binding.title.text = address.subLocality
                        getWeather(address.latitude, address.longitude)

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun getWeather(latitude: Double, longitude: Double) {
        Log.d(TAG, "getWeather: ")
        val serviceApi = ApiClientWeather().service

        serviceApi.getWeatherByLonAndLot(latitude.toString(), longitude.toString())
            .enqueue(object : Callback<Weather> {
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    val anim = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim_weather_fragment)
                    if (response.isSuccessful) {
                        binding.progressLinear.gone()
                        binding.main.visible()
                        binding.main.startAnimation(anim)

                        val main = response.body()?.main
                        val temp = (main?.temp!! - 273.15)
                        val max_temp = (main.temp_max - 273.15)
                        val min_temp = (main.temp_min - 273.15)
                        val sunrise = response.body()?.sys?.sunrise
                        val sunset = response.body()?.sys?.sunset
                        val weatherMain = response.body()!!.weather[0].main
                        val speedWindy = response.body()!!.wind.speed
                        val humidityPrecent = response.body()!!.main.humidity
                        val feels = response.body()!!.main.feels_like
                        val name = response.body()!!.name

                        setUI(
                            name,
                            temp,
                            max_temp,
                            min_temp,
                            sunrise!!.toInt(),
                            sunset!!.toInt(),
                            weatherMain,
                            speedWindy,
                            humidityPrecent,
                            feels
                        )

                    }


                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })


    }

    private fun setUI(
        name: String,
        temp: Double,
        max_temp: Double,
        min_temp: Double,
        sunrise: Int,
        sunset: Int,
        weatherMain: String,
        speedWindy: Double,
        humidityPrecent: Int,
        feels: Double
    ) {

        val temperature = temp.toInt().toString() + "°"
        val format = SimpleDateFormat("HH:mm").format(sunrise)
        val format1 = SimpleDateFormat("HH:mm").format(sunset)
        val max_tempe = max_temp.toInt().toString() + "°"
        val min_tempe = min_temp.toInt().toString() + "°"

        val speedWind = speedWindy.toString() + "m/s"
        val humidityPre = "$humidityPrecent%"
        val feelsLike = (feels - 273.15).toInt().toString() + "°"


        try {
            binding.apply {

                windSpeedTv.text = speedWind
                humidityPrecenteTv.text = humidityPre
                feelsLikeTv.text = feelsLike
                val currentDate = Date(System.currentTimeMillis())
                val simpleFormat = SimpleDateFormat("EEEE, MMMM d")
                dateTv.text = simpleFormat.format(currentDate).toString()

                when (weatherMain) {
                    "Clouds" -> {
                        weatherName.text = resources.getString(R.string.cloud)
                        cloudIv.setImageResource(R.drawable.ic_cloud)
                        feelsLikeIv.setImageResource(R.drawable.ic_cloud)
                    }
                    "Clear" -> {
                        weatherName.text = resources.getString(R.string.clear)
                        cloudIv.setImageResource(R.drawable.ic_sun)
                        feelsLikeIv.setImageResource(R.drawable.ic_sun)
                    }
                    "Rain" -> {
                        weatherName.text = resources.getString(R.string.rain)
                        cloudIv.setImageResource(R.drawable.ic_rainy)
                        feelsLikeIv.setImageResource(R.drawable.ic_rainy)
                    }
                    "Snow" -> {
                        weatherName.text = resources.getString(R.string.snow)
                        cloudIv.setImageResource(R.drawable.ic_snow)
                        feelsLikeIv.setImageResource(R.drawable.ic_snow)
                    }
                    "Smoke" -> {
                        weatherName.text = resources.getString(R.string.smoke)
                        cloudIv.setImageResource(R.drawable.ic_smoke)
                        feelsLikeIv.setImageResource(R.drawable.ic_smoke)
                    }
                }
                subCity.text = name

                temperatureTv.text = temperature

                maxTemp.text = max_tempe
                minTemp.text = min_tempe

                sunriseTv.text = format
                sunsetTv.text = format1

            }
        } catch (e: Exception) {

        }


    }

    private fun getPermission() {
        Dexter.withContext(binding.root.context)
            .withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.INTERNET
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    if (report.areAllPermissionsGranted()) {
                        getLocationAddress()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest>,
                    token: PermissionToken
                ) {
                }
            }).check()
    }


}