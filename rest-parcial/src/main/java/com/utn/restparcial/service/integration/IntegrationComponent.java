package com.utn.restparcial.service.integration;

import com.utn.restparcial.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IntegrationComponent {
    private RestTemplate rest;
    private static  String url = "http://localhost:8080/countries/1";

    @PostConstruct
    private void init(){
        rest = new RestTemplateBuilder().build();
    }

    public Country getCountriesFromApi(){ return rest.getForObject(url,Country.class);}
}
