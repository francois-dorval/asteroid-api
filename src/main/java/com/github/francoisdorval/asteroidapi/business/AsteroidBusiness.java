package com.github.francoisdorval.asteroidapi.business;

import com.github.francoisdorval.asteroidapi.controller.dto.Asteroid;
import com.github.francoisdorval.asteroidapi.dao.NasaDao;
import com.github.francoisdorval.asteroidapi.dao.dto.NasaNearEarthObject;
import com.github.francoisdorval.asteroidapi.util.DateUtil;
import com.github.francoisdorval.asteroidapi.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AsteroidBusiness {

    BigDecimal DANGER_LIMIT_KM=BigDecimal.valueOf(1000000.0);
    @Autowired
    NasaDao nasaDao;



    public List<Asteroid> getAsteroidsForTomorrow() {
        String today = DateUtil.todayAsString();
        List<NasaNearEarthObject> nasaNearEarthObject = nasaDao.getAsteroids(today);
        List<Asteroid> res = Mapper.map(nasaNearEarthObject);

        return res;

    }

    public Boolean areWeInDanger() {
        String today = DateUtil.todayAsString();
        List<NasaNearEarthObject> nasaNearEarthObject = nasaDao.getAsteroids(today);
        List<Asteroid> asteroids = Mapper.map(nasaNearEarthObject);
        boolean result = asteroids.stream().anyMatch(ast -> ast.getDistanceKilometers().compareTo(DANGER_LIMIT_KM) < 0);
        return result;
    }

}


