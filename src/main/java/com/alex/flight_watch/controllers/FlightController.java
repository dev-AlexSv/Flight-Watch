package com.alex.flight_watch.controllers;

import com.alex.flight_watch.dto.WeatherResponse;
import com.alex.flight_watch.entities.Flight;
import com.alex.flight_watch.services.FlightService;
import com.alex.flight_watch.services.WeatherRiskAssessmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    private final FlightService flightService;
    private final WeatherRiskAssessmentService weatherRiskAssessmentService;

    public FlightController(
            FlightService flightService,
            WeatherRiskAssessmentService weatherRiskAssessmentService
    ) {
        this.flightService = flightService;
        this.weatherRiskAssessmentService = weatherRiskAssessmentService;
    }


    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights() {
        List<Flight> flightsList =
    }

    @GetMapping("flights{id}")
    public ResponseEntity<List<Flight>> getFlights() {
        List<Flight> flightsList =
    }


    @GetMapping("/{id}/assess-risk")
    public ResponseEntity<Flight> assessFlightRisk() {

    }
}
