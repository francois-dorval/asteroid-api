package com.github.francoisdorval.asteroidapi.dao;

import com.github.francoisdorval.asteroidapi.dao.dto.NasaNearEarthObject;

import java.util.List;


public interface NasaDao {
    public List<NasaNearEarthObject> getAsteroids(String date);
}
