package com.alex.flight_watch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("airports")
public class Airport {

    @Id
    private String icaoCode;
    private String name;
    private String city;
    private double latitude;
    private double longitude;

    public Airport(String icaoCode, String name, String city, double latitude, double longitude) {
        this.icaoCode = icaoCode;
        this.name = name;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
