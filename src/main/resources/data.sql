SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM weather_snapshots;
DELETE FROM flights;
DELETE FROM airports;


SET FOREIGN_KEY_CHECKS = 1;
-- -----------------------------------------------------
-- 1. AIRPORTS (Real Geographic Coordinates)
-- -----------------------------------------------------
INSERT INTO airports (icao_code, name, city, latitude, longitude) VALUES
('KJFK', 'John F. Kennedy International Airport', 'New York', 40.6413, -73.7781),
('EGLL', 'London Heathrow Airport', 'London', 51.4700, -0.4543),
('RJTT', 'Tokyo Haneda Airport', 'Tokyo', 35.5494, 139.7798),
('OMDB', 'Dubai International Airport', 'Dubai', 25.2532, 55.3657),
('KSFO', 'San Francisco International Airport', 'San Francisco', 37.6213, -122.3790),
('LFPG', 'Charles de Gaulle Airport', 'Paris', 49.0097, 2.5479),
('WSSS', 'Singapore Changi Airport', 'Singapore', 1.3644, 103.9915),
('YSSY', 'Sydney Kingsford Smith Airport', 'Sydney', -33.9399, 151.1753);
-- -----------------------------------------------------
-- 2. FLIGHTS
-- -----------------------------------------------------
INSERT INTO flights (flight_number, origin_icao_code, destination_icao_code, scheduled_departure, status, risk_score) VALUES
('FW101', 'KJFK', 'EGLL', '2026-06-01 08:00:00', 'SCHEDULED', 'LOW'),
('FW202', 'EGLL', 'OMDB', '2026-06-01 10:30:00', 'SCHEDULED', 'LOW'),
('FW303', 'RJTT', 'KSFO', '2026-06-01 14:00:00', 'SCHEDULED', 'LOW'),
('FW404', 'KSFO', 'KJFK', '2026-06-01 18:15:00', 'SCHEDULED', 'LOW'),
('FW505', 'OMDB', 'RJTT', '2026-06-02 01:00:00', 'SCHEDULED', 'LOW'),
('FW606', 'LFPG', 'WSSS', '2026-06-02 06:45:00', 'SCHEDULED', 'LOW'),
('FW707', 'WSSS', 'YSSY', '2026-06-02 11:20:00', 'SCHEDULED', 'LOW');