package com.adematici.weatherapp.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.adematici.weatherapp.R
import com.adematici.weatherapp.model.Weather
import com.adematici.weatherapp.util.Resource
import com.adematici.weatherapp.viewmodel.WeatherScreenViewModel

@ExperimentalCoilApi
@Composable
fun WeatherScreen(
    city: String?,
    viewModel: WeatherScreenViewModel = hiltViewModel()
) {

    val weatherData = produceState<Resource<Weather>>(initialValue = Resource.Loading()) {
        value = viewModel.getWeatherData(city!!)
    }.value

    val weather = weatherData.data

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = city!!) }
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (weatherData) {
                is Resource.Success -> {
                    WeatherCard(weather = weather!!)
                }
                is Resource.Error -> {
                    Text(text = weatherData.message!!)
                }
                is Resource.Loading -> {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun WeatherCard(
    weather: Weather
) {
    val imageUrl = "https://openweathermap.org/img/wn/${weather.weather[0].icon}.png"

    Card(
        border = BorderStroke(3.dp, Color.Red),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .size(350.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            WeatherStateImage(imagerUrl = imageUrl)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = weather.weather[0].description.uppercase())
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                WeatherDataInfoRow(
                    image = R.drawable.humidity,
                    description = weather.main.humidity.toString()
                )
                WeatherDataInfoRow(
                    image = R.drawable.temperature,
                    description = weather.main.temp.toString()
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun WeatherStateImage(
    imagerUrl: String
) {
    Image(
        painter = rememberImagePainter(imagerUrl),
        contentDescription = "Image",
        modifier = Modifier.size(80.dp)
    )
}

@Composable
fun WeatherDataInfoRow(
    image: Int,
    description: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "image",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = description)
    }
}