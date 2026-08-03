package com.alex.flight_watch.services;

import com.alex.flight_watch.repositories.AirportRepository;
import com.alex.flight_watch.repositories.FlightRepository;
import com.alex.flight_watch.repositories.WeatherSnapshotRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final WeatherSnapshotRepository weatherSnapshotRepository;

    public FlightService(
            FlightRepository flightRepository,
            AirportRepository airportRepository,
            WeatherSnapshotRepository weatherSnapshotRepository
    ) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.weatherSnapshotRepository = weatherSnapshotRepository;
    }
}
