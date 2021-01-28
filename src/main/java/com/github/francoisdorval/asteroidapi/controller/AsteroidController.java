package com.github.francoisdorval.asteroidapi.controller;

import com.github.francoisdorval.asteroidapi.business.AsteroidBusiness;
import com.github.francoisdorval.asteroidapi.controller.dto.Asteroid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * le point d'entrée de l'API...
 *
 * @author franc
 */
@RestController
public class AsteroidController {

    @Autowired
    AsteroidBusiness asteroidBusiness;

    @RequestMapping(value = "/asteroids", method = RequestMethod.GET)
    @CrossOrigin()

    public List<Asteroid> getAsteroidsForTomorrow()   {
        List <Asteroid> res= asteroidBusiness.getAsteroidsForTomorrow();
        return res;//spoilBusiness.getCharactersInSeason(Season.fromString(season));
    }


}
