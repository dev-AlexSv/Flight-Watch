package com.alex.flight_watch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    @JsonProperty("current")
    private CurrentWeather current;

    public WeatherResponse() {}

    public CurrentWeather getCurrent() { return current; }
    public void setCurrent(CurrentWeather current) { this.current = current; }

    public static class CurrentWeather {

        @JsonProperty("temperature_2m")
        private double temperature;

        @JsonProperty("wind_speed_10m")
        private double windSpeed;

        @JsonProperty("weather_code")
        private int weatherCode;

        private String time;

        public CurrentWeather() {}

        public double getTemperature() { return temperature; }
        public void setTemperature(double temperature) { this.temperature = temperature; }

        public double getWindSpeed() { return windSpeed; }
        public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }

        public int getWeatherCode() { return weatherCode; }
        public void setWeatherCode(int weatherCode) { this.weatherCode = weatherCode; }

        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }
    }
}