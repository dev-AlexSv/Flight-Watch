package com.alex.flight_watch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("weather_snapshots")
public class WeatherSnapshot {
    @Id
    private Long id;
    private String airportIcaoCode;
    private double windSpeedKmh;
    private double temperatureCelsius;
    private int weatherCode;
    private Instant capturedAt;

    public WeatherSnapshot() {}

    public WeatherSnapshot(Long id, String airportIcaoCode, double windSpeedKmh, double temperatureCelsius, int weatherCode, Instant capturedAt) {
        this.id = id;
        this.airportIcaoCode = airportIcaoCode;
        this.windSpeedKmh = windSpeedKmh;
        this.temperatureCelsius = temperatureCelsius;
        this.weatherCode = weatherCode;
        this.capturedAt = capturedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAirportIcaoCode() { return airportIcaoCode; }
    public void setAirportIcaoCode(String airportIcaoCode) { this.airportIcaoCode = airportIcaoCode; }

    public double getWindSpeedKmh() { return windSpeedKmh; }
    public void setWindSpeedKmh(double windSpeedKmh) { this.windSpeedKmh = windSpeedKmh; }

    public double getTemperatureCelsius() { return temperatureCelsius; }
    public void setTemperatureCelsius(double temperatureCelsius) { this.temperatureCelsius = temperatureCelsius; }

    public int getWeatherCode() { return weatherCode; }
    public void setWeatherCode(int weatherCode) { this.weatherCode = weatherCode; }

    public Instant getCapturedAt() { return capturedAt; }
    public void setCapturedAt(Instant capturedAt) { this.capturedAt = capturedAt; }

}
