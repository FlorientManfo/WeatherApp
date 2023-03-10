package com.example.weatherapplication.weather_feature.presentation.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.weather_feature.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    contentColor: Color,
    modifier: Modifier = Modifier,
) {
    val formattedTime = remember(weatherData){
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = formattedTime,
            color = contentColor
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            modifier = Modifier.size(60.dp),
            contentDescription = null
        )
        Text(
            text = "${weatherData.temperatureCelsius}°C",
            color = contentColor,
            fontWeight = FontWeight.Bold
        )
    }
}