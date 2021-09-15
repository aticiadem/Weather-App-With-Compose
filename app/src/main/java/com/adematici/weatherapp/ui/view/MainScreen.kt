package com.adematici.weatherapp.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adematici.weatherapp.ui.theme.Purple500

@Composable
fun MainScreen(navController: NavController) {

    var city by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Weather App") }
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            CommonTextField(
                text = city,
                placeholder = "Write Your City",
                onValueChange = { city = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            CommonButton {
                if (city.isNotBlank()) {
                    navController.navigate(
                        route = "weather_screen/$city"
                    )
                }
            }
        }
    }
}

@Composable
fun CommonTextField(
    text: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        label = { Text(text = placeholder) },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple500,
            cursorColor = Color.Black
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
    )
}

@Composable
fun CommonButton(
    onClickListener: () -> Unit
) {
    Button(
        onClick = {
            onClickListener()
        },
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.fillMaxWidth().height(54.dp).padding(
            start = 10.dp,
            end = 10.dp
        )
    ) {
        Text(text = "Show Weather")
    }
}