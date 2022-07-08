package com.e444er.weather.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.e444er.weather.data.mappers.toWeatherInfo
import com.e444er.weather.data.remote.WeatherApi
import com.e444er.weather.domain.repository.WeatherRepository
import com.e444er.weather.domain.utils.Resource
import com.e444er.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}