package com.adematici.weatherapp.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("weather")
    val weather: List<WeatherDetail>,
    @SerializedName("wind")
    val wind: Wind
)