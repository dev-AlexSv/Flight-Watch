package com.alex.flight_watch.repositories;

import com.alex.flight_watch.entities.Flight;
import com.alex.flight_watch.entities.RiskScore;
import com.alex.flight_watch.entities.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends ListCrudRepository<Flight, Long> {

    @Query("SELECT * FROM flights WHERE status = :status")
    List<Flight> fetchFlightsByStatus(@Param("status") Status status);

    @Query("SELECT * FROM flights WHERE origin_icao_code = :originIcao")
    List<Flight> fetchDeparturesFromAirport(@Param("originIcao") String originIcao);

    @Query("SELECT * FROM flights WHERE risk_score = :riskScore")
    List<Flight> fetchFlightsByRiskLevel(@Param("riskScore") RiskScore riskScore);

    @Query("SELECT * FROM flights WHERE origin_icao_code = :icao OR destination_icao_code = :icao")
    List<Flight> fetchAllFlightsForAirport(@Param("icao") String icao);
}
