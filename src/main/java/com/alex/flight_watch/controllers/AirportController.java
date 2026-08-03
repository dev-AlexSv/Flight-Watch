package com.alex.flight_watch.controllers;

import com.alex.flight_watch.services.WeatherRiskEngineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    private final WeatherRiskEngineService weatherRiskEngineService;

    public AirportController(WeatherRiskEngineService weatherRiskEngineService) {
        this.weatherRiskEngineService = weatherRiskEngineService;
    }

    @GetMapping("/api/v1/airports")


    @PostMapping("/api/v1/airports")


}
