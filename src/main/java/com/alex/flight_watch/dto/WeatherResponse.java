package com.alex.flight_watch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    public WeatherResponse() {}

    public WeatherResponse(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    // Inner static class representing the "current_weather" object
    public static class CurrentWeather {

        private double temperature;

        @JsonProperty("windspeed")
        private double windSpeed;

        @JsonProperty("weathercode")
        private int weatherCode;

        private String time;

        public CurrentWeather() {}

        public CurrentWeather(double temperature, double windSpeed, int weatherCode, String time) {
            this.temperature = temperature;
            this.windSpeed = windSpeed;
            this.weatherCode = weatherCode;
            this.time = time;
        }

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