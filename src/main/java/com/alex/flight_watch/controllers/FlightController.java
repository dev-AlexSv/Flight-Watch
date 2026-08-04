package com.alex.flight_watch.controllers;

import com.alex.flight_watch.services.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/api/v1/flights")



    @GetMapping("api/v1/flights/{id}/assess-risk")
}
