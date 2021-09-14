package com.adematici.weatherapp.model

import com.google.gson.annotations.SerializedName

data class WeatherDetail(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("main")
    val main: String
)