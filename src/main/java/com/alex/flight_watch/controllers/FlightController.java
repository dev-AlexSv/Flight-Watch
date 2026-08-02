package com.alex.flight_watch.controllers;

import com.alex.flight_watch.services.FlightService;
import org.springframework.stereotype.Controller;

@Controller
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
}
