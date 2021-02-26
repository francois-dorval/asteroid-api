package com.github.francoisdorval.asteroidapi.business;

import com.github.francoisdorval.asteroidapi.controller.dto.Asteroid;
import com.github.francoisdorval.asteroidapi.dao.NasaDao;
import com.github.francoisdorval.asteroidapi.dao.dto.NasaNearEarthObject;
import com.github.francoisdorval.asteroidapi.util.DateUtil;
import com.github.francoisdorval.asteroidapi.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsteroidBusiness {

    @Autowired
    NasaDao nasaDao;

    public List<Asteroid> getAsteroidsForTomorrow() {
        String today = DateUtil.todayAsString();
        List<NasaNearEarthObject> asteroids = nasaDao.getAsteroids(today);
        List<Asteroid> res = Mapper.map(asteroids);

        return res;

    }
}
