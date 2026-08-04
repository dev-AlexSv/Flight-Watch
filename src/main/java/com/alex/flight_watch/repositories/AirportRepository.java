package com.alex.flight_watch.repositories;

import com.alex.flight_watch.entities.Airport;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends ListCrudRepository<Airport, String> {

    @Query("SELECT * FROM airports WHERE icao_code = :icaoCode")
    Optional<Airport> findAirportByIcaoCode(@Param("icaoCode") String icaoCode);

    @Query("SELECT * FROM airports WHERE city = :city")
    List<Airport> findAirportsInCity(@Param("city") String city);
}
