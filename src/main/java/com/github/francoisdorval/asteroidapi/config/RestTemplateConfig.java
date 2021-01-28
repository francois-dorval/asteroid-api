package com.github.francoisdorval.asteroidapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean(name="NasaRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
