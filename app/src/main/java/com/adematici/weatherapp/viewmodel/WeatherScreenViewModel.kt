package com.adematici.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import com.adematici.weatherapp.model.Weather
import com.adematici.weatherapp.repository.WeatherRepository
import com.adematici.weatherapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    suspend fun getWeatherData(city: String): Resource<Weather> {
        return repository.getWeatherData(city)
    }
}