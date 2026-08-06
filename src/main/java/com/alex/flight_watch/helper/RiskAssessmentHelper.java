package com.alex.flight_watch.helper;

import com.alex.flight_watch.entities.Flight;
import com.alex.flight_watch.entities.RiskScore;
import com.alex.flight_watch.entities.Status;
import com.alex.flight_watch.entities.WeatherSnapshot;
import com.alex.flight_watch.repositories.FlightRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class RiskAssessmentHelper {

    private final Set<Integer> CRITICAL_WMO = Set.of(75, 82, 86, 95, 96, 99);
    private final Set<Integer> HIGH_WMO = Set.of(65, 67, 81);
    private final Set<Integer> MODERATE_WMO = Set.of(45, 48, 51, 52, 53, 54, 55, 61, 63);

    public RiskScore calculateRiskScore(WeatherSnapshot snapshot) {
        double windSpeedKmh = snapshot.getWindSpeedKmh();
        int weatherCode = snapshot.getWeatherCode();



        if (CRITICAL_WMO.contains(weatherCode) || windSpeedKmh > 65) {
            return RiskScore.CRITICAL;
        }

        if (HIGH_WMO.contains(weatherCode) || (windSpeedKmh > 45 && windSpeedKmh <= 65)) {
            return RiskScore.HIGH;
        }

        if (MODERATE_WMO.contains(weatherCode) || (windSpeedKmh > 25 && windSpeedKmh <= 45)) {
            return RiskScore.MODERATE;
        }

        return RiskScore.LOW;
    }


    public Status determineFlightStatus(RiskScore riskScore, Status currentStatus) {
        if (currentStatus == Status.CANCELLED) return Status.CANCELLED;

        return switch (riskScore) {
            case CRITICAL -> Status.CANCELLED;
            case HIGH -> Status.DELAYED;
            case MODERATE, LOW -> {
                if (currentStatus == Status.SCHEDULED) {
                    yield Status.DELAYED;
                }

                yield currentStatus;
            }
        };
    }
}
