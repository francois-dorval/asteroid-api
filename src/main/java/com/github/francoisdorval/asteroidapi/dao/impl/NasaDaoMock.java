package com.github.francoisdorval.asteroidapi.dao.impl;

import com.github.francoisdorval.asteroidapi.dao.NasaDao;
import com.github.francoisdorval.asteroidapi.dao.dto.CloseApproachData;
import com.github.francoisdorval.asteroidapi.dao.dto.MissDistance;
import com.github.francoisdorval.asteroidapi.dao.dto.NasaNearEarthObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Profile("mock")
@Repository
public class NasaDaoMock implements NasaDao {

    private NasaNearEarthObject mockNearEarthObject(String name, String id, String kilometers){
        NasaNearEarthObject neo = new NasaNearEarthObject();
        neo.setName(name);
        neo.setId(id);
        neo.setCloseApproachData(new ArrayList<>());
        CloseApproachData closeApproachData = new CloseApproachData();
        MissDistance missDistance = new MissDistance();
        missDistance.setKilometers(kilometers);
        closeApproachData.setMissDistance(missDistance);
        neo.getCloseApproachData().add(closeApproachData);
        return neo;
    }

    @Override
    public List<NasaNearEarthObject> getAsteroids(String date) {
        List<NasaNearEarthObject> objs = new ArrayList<>();
        objs.add(mockNearEarthObject("Asteromachin", "1", "100000,2225"));
        objs.add(mockNearEarthObject("Asterotruc", "2", "1234,01"));
        objs.add(mockNearEarthObject("ʻOumuamua", "3", "4946111,01"));
        return objs;
    }
}
