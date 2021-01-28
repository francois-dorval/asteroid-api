package com.github.francoisdorval.asteroidapi.util;

import com.github.francoisdorval.asteroidapi.controller.dto.Asteroid;
import com.github.francoisdorval.asteroidapi.dao.dto.NasaNearEarthObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<Asteroid> map(List<NasaNearEarthObject> neos) {
        List<Asteroid> res = new ArrayList<>();
        if (neos == null) {
            return res;
        }
        for (NasaNearEarthObject neo : neos) {
            res.add(map(neo));
        }
        return res;
    }

    public static Asteroid map(NasaNearEarthObject neo) {
        Asteroid asteroid = new Asteroid();
        asteroid.setName(neo.getName());
        asteroid.setId(neo.getId());
        BigDecimal distance = new BigDecimal(neo.getCloseApproachData().get(0).getMissDistance().getKilometers().replace(',', '.'));
        asteroid.setDistanceKilometers(distance);
        return asteroid;

    }
}
