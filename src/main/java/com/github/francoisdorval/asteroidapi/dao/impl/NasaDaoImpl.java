package com.github.francoisdorval.asteroidapi.dao.impl;

import com.github.francoisdorval.asteroidapi.config.JsonPathConfig;
import com.github.francoisdorval.asteroidapi.dao.NasaDao;
import com.github.francoisdorval.asteroidapi.dao.dto.NasaNearEarthObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Repository
@Profile("!mock")
public class NasaDaoImpl implements NasaDao {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<NasaNearEarthObject> getAsteroids(String date) {

        JsonPathConfig.config();


        String url = "https://api.nasa.gov/neo/rest/v1/feed";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("api_key", "TwnS47xdV220n7daHQ2bD7mTeEMgNPsPzYLe2vs7")
                .queryParam("start_date", date)
                .queryParam("end_date", date);

        String fullUrl = builder.toUriString();

        ResponseEntity<String> responseString = restTemplate.getForEntity(fullUrl, String.class);
        DocumentContext document = JsonPath.parse(responseString.getBody());
        List<NasaNearEarthObject> neo = document.read("$.near_earth_objects." + date, new TypeRef<List<NasaNearEarthObject>>() {});
        return neo;


    }
}
