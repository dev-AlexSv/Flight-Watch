CREATE TABLE IF NOT EXISTS airports (
    icao_code VARCHAR(4) PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    city VARCHAR(100) NOT NULL,
    latitude DECIMAL(10, 6) NOT NULL,
    longitude DECIMAL(10, 6) NOT NULL
);

CREATE TABLE IF NOT EXISTS flights (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(10) NOT NULL,
    origin_icao_code VARCHAR(4) NOT NULL,
    destination_icao_code VARCHAR(4) NOT NULL,
    scheduled_departure DATETIME NOT NULL,
    risk_score ENUM('LOW', 'MODERATE', 'HIGH', 'CRITICAL') DEFAULT 'LOW',
    status VARCHAR(20) DEFAULT 'SCHEDULED',
    FOREIGN KEY (origin_icao_code) REFERENCES airports(icao_code),
    FOREIGN KEY (destination_icao_code) REFERENCES airports(icao_code)
);

CREATE TABLE IF NOT EXISTS weather_snapshots (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    airport_icao_code VARCHAR(4) NOT NULL,
    wind_speed_kmh DECIMAL(5, 2),
    temperature_celsius DECIMAL(4, 2),
    weather_code INT,
    captured_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (airport_icao_code) REFERENCES airports(icao_code)
);