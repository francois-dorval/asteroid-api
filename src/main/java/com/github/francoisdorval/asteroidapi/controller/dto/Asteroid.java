package com.github.francoisdorval.asteroidapi.controller.dto;

import java.math.BigDecimal;

public class Asteroid {
    String id;
    String name;
    BigDecimal distanceKilometers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDistanceKilometers() {
        return distanceKilometers;
    }

    public void setDistanceKilometers(BigDecimal distanceKilometers) {
        this.distanceKilometers = distanceKilometers;
    }
}
