package com.alex.flight_watch.controllers;

import com.alex.flight_watch.services.WeatherRiskEngineService;
import org.springframework.stereotype.Controller;

@Controller
public class AirportController {

    private final WeatherRiskEngineService weatherRiskEngineService;

    public AirportController(WeatherRiskEngineService weatherRiskEngineService) {
        this.weatherRiskEngineService = weatherRiskEngineService;
    }
}
