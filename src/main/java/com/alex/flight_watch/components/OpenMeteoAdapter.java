package com.alex.flight_watch.components;

import com.alex.flight_watch.dto.WeatherResponse;
import com.alex.flight_watch.entities.WeatherSnapshot;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.Instant;

@Component
public class OpenMeteoAdapter {

    private final RestClient openMeteoRestClient;

    public OpenMeteoAdapter(RestClient openMeteoRestClient) {
        this.openMeteoRestClient = openMeteoRestClient;
    }

    public WeatherSnapshot fetchCurrentWeather(String icaoCode, double latitude, double longitude) {
        WeatherResponse response = openMeteoRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam("current", "temperature_2m,wind_speed_10m,weather_code")
                        .build())
                .retrieve()
                .body(WeatherResponse.class);

        if (response == null || response.getCurrent() == null) {
            throw new RuntimeException("Failed to fetch weather data from Open-Meteo for airport: " + icaoCode);
        }

        WeatherResponse.CurrentWeather current = response.getCurrent();

        // Convert API response into domain WeatherSnapshot object
        return new WeatherSnapshot(
                null,
                icaoCode,
                current.getWindSpeed(),
                current.getTemperature(),
                current.getWeatherCode(),
                Instant.now()
        );
    }
}
