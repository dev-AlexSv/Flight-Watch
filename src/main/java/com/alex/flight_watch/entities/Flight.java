package com.alex.flight_watch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("flights")
public class Flight {

    @Id private Long id;
    private String flightNumber;
    private String originIcaoCode;
    private String destinationIcaoCode;
    private LocalDateTime scheduledDeparture;
    private RiskScore riskScore;
    private Status status;

    public Flight(Long id, RiskScore riskScore, LocalDateTime scheduledDeparture, String destinationIcaoCode, String originIcaoCode, String flightNumber, Status status) {
        this.id = id;
        this.riskScore = riskScore;
        this.scheduledDeparture = scheduledDeparture;
        this.destinationIcaoCode = destinationIcaoCode;
        this.originIcaoCode = originIcaoCode;
        this.flightNumber = flightNumber;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOriginIcaoCode() {
        return originIcaoCode;
    }

    public void setOriginIcaoCode(String originIcaoCode) {
        this.originIcaoCode = originIcaoCode;
    }

    public String getDestinationIcaoCode() {
        return destinationIcaoCode;
    }

    public void setDestinationIcaoCode(String destinationIcaoCode) {
        this.destinationIcaoCode = destinationIcaoCode;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public RiskScore getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(RiskScore riskScore) {
        this.riskScore = riskScore;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
