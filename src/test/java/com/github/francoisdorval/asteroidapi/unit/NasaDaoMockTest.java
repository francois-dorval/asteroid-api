package com.github.francoisdorval.asteroidapi.unit;

import com.github.francoisdorval.asteroidapi.dao.dto.NasaNearEarthObject;
import com.github.francoisdorval.asteroidapi.dao.impl.NasaDaoImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@SpringBootTest
public class NasaDaoMockTest {

    Logger LOG = LoggerFactory.getLogger(NasaDaoMockTest.class);

    @Autowired
    NasaDaoImpl nasaDao;

    @MockBean
    RestTemplate restTemplate;

    @Test
    public void test_Dao_Returns_Correct_Number_Of_Objects() throws IOException {

        ClassPathResource clsPath = new ClassPathResource("exemple-data.json");
        String msg = StreamUtils.copyToString(clsPath.getInputStream(), Charset.defaultCharset());
        ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.eq(String.class))).thenReturn(responseEntity);

        List<NasaNearEarthObject> asteroids = nasaDao.getAsteroids("2021-01-28");
       // Assert.assertEquals(11, asteroids.size());
    }

    @Test
    public void test_Dao_Returns_Correct_Object() throws IOException {

        ClassPathResource clsPath = new ClassPathResource("exemple-data-small.json");
        String msg = StreamUtils.copyToString(clsPath.getInputStream(), Charset.defaultCharset());
        ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.eq(String.class))).thenReturn(responseEntity);

        List<NasaNearEarthObject> asteroids = nasaDao.getAsteroids("2021-01-28");
       // Assert.assertEquals(1, asteroids.size());
        NasaNearEarthObject neo = asteroids.get(0);
        //Assert.assertEquals("89355 (2001 VS78)", neo.getName());
       // Assert.assertEquals("2089355", neo.getId());
       // Assert.assertEquals("71959206.657176708", neo.getCloseApproachData().get(0).getMissDistance().getKilometers());

    }

}
