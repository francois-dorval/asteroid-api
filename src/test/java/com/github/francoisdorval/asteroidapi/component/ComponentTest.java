package com.github.francoisdorval.asteroidapi.component;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("mock")
public class ComponentTest {
    Logger LOG = LoggerFactory.getLogger(ComponentTest.class);


    @LocalServerPort
    private int port;

    @Test
    public void test_Get_Asteroids() {
        String result = new RestTemplate().getForObject("http://localhost:" + port + "/asteroids",
                String.class);
        LOG.info("result : "+result);
        assertThat(result.contains("Asteromachin")).isTrue();

    }
}