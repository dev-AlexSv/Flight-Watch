package com.alex.flight_watch.services;

import com.alex.flight_watch.components.OpenMeteoAdapter;
import com.alex.flight_watch.entities.*;
import com.alex.flight_watch.exceptions.NotFoundException;
import com.alex.flight_watch.helper.RiskAssessmentHelper;
import com.alex.flight_watch.repositories.AirportRepository;
import com.alex.flight_watch.repositories.FlightRepository;
import com.alex.flight_watch.repositories.WeatherSnapshotRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WeatherRiskAssessmentService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final WeatherSnapshotRepository weatherSnapshotRepository;
    private final OpenMeteoAdapter openMeteoAdapter;
    private final RiskAssessmentHelper riskAssessmentHelper;

    public WeatherRiskAssessmentService(FlightRepository flightRepository, AirportRepository airportRepository, WeatherSnapshotRepository weatherSnapshotRepository, OpenMeteoAdapter openMeteoAdapter, RiskAssessmentHelper riskAssessmentHelper) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.weatherSnapshotRepository = weatherSnapshotRepository;
        this.openMeteoAdapter = openMeteoAdapter;
        this.riskAssessmentHelper = riskAssessmentHelper;
    }

    @@Transactional
    public Flight applyRiskAndPersist(Flight flight, WeatherSnapshot weatherSnapshot) {
        WeatherSnapshot savedWeatherSnapshot = weatherSnapshotRepository.save(weatherSnapshot);

        RiskScore snapshotRiskScore = riskAssessmentHelper.calculateRiskScore(savedWeatherSnapshot);
        Status snapshotStatus = riskAssessmentHelper.determineFlightStatus(snapshotRiskScore, flight.getStatus());

        flight.setRiskScore(snapshotRiskScore);
        flight.setStatus(snapshotStatus);

        Flight savedFlight = flightRepository.save(flight);

        return savedFlight;
    }

    public Flight evaluateAndApplyRisk(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight ID Not Found......." + id));

        Airport originAirport = airportRepository.findAirportByIcaoCode(flight.getOriginIcaoCode())
                .orElseThrow(() -> new NotFoundException("Origin Airport Not Found......" + flight.getOriginIcaoCode()));

        String originAirportIcaoCode = originAirport.getIcaoCode();
        double latitude = originAirport.getLatitude();
        double longitude = originAirport.getLongitude();

        WeatherSnapshot weatherSnapshot = openMeteoAdapter.fetchCurrentWeather(originAirportIcaoCode, latitude, longitude);

        return applyRiskAndPersist(flight, weatherSnapshot);
    }

}
