package com.alex.flight_watch.repositories;

import com.alex.flight_watch.entities.WeatherSnapshot;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WeatherSnapshotRepository extends ListCrudRepository<WeatherSnapshot, Long> {

    @Query("SELECT * FROM weather_snapshots WHERE airport_icao_code = :icaoCode ORDER BY captured_at DESC")
    List<WeatherSnapshot> fetchHistoryForAirport(@Param("icaoCode") String icaoCode);

    @Query("SELECT * FROM weather_snapshots WHERE airport_icao_code = :icaoCode ORDER BY captured_at DESC LIMIT 1")
    Optional<WeatherSnapshot> fetchLatestSnapshotForAirport(@Param("icaoCode") String icaoCode);
}
