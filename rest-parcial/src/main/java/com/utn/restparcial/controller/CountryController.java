package com.utn.restparcial.controller;

import com.utn.restparcial.model.Country;
import com.utn.restparcial.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
    IntegrationService integrationService;

    @GetMapping("/country")
    public Country getCountry(){
        return integrationService.getCountry();
    }
}
