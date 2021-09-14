package com.adematici.weatherapp.repository

import com.adematici.weatherapp.model.Weather
import com.adematici.weatherapp.service.WeatherAPI
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class WeatherRepository(private val api: WeatherAPI) {

    suspend fun getWeatherData(city: String): Weather {
        return api.getWeatherData(city)
    }

}