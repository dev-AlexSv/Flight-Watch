package com.alex.flight_watch.controllers;

import com.alex.flight_watch.dto.WeatherResponse;
import com.alex.flight_watch.entities.Flight;
import com.alex.flight_watch.exceptions.NotFoundException;
import com.alex.flight_watch.services.FlightService;
import com.alex.flight_watch.services.WeatherRiskAssessmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/api/v1/flights")
    public ResponseEntity<List<Flight>> getFlights() {
        List<Flight> flightsList = weatherRiskAssessmentService.getAllFlights();

        return ResponseEntity.ok(flightsList);
    }

    @GetMapping("/api/v1/flights/{id}")
    public ResponseEntity<Flight> getFlightById(
            @PathVariable Long id
    ) {
        Flight flight = weatherRiskAssessmentService.getFlightById(id)
                .orElseThrow(() -> new NotFoundException("Id Not found: " + id));
        return ResponseEntity.ok(flight);
    }


    @PostMapping("/api/v1/flights/{id}/assess-risk")
    public ResponseEntity<Flight> assessFlightRisk(
            @PathVariable Long id
    ) {
        Flight flight = weatherRiskAssessmentService.evaluateAndApplyRisk(id);

        return ResponseEntity.ok(flight);
    }
}
