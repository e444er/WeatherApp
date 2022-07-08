package com.e444er.weather.domain.repository

import com.e444er.weather.domain.utils.Resource
import com.e444er.weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

}