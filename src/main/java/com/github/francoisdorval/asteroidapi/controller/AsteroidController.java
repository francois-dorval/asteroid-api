package com.github.francoisdorval.asteroidapi.controller;

import com.github.francoisdorval.asteroidapi.business.AsteroidBusiness;
import com.github.francoisdorval.asteroidapi.controller.dto.Asteroid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Tag(name = "asteroid", description = "the asteroid API")

public class AsteroidController {

    @Autowired
    AsteroidBusiness asteroidBusiness;

    @Operation(summary = "Get all asteroids near earth tomorrow", description = "Name, id, distance", tags = { "danger!" })

    @RequestMapping(value = "/asteroids", method = RequestMethod.GET)
    @CrossOrigin()
    public ResponseEntity<List<Asteroid>> getAsteroidsForTomorrow()   {
        return new ResponseEntity<>(asteroidBusiness.getAsteroidsForTomorrow(), HttpStatus.OK);
    }


}
