package com.utn.restparcial.service;

import com.utn.restparcial.model.Country;
import com.utn.restparcial.service.integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {
    @Autowired
    IntegrationComponent integrationComponent;

    public Country getCountry(){
        return integrationComponent.getCountriesFromApi();
    }
}
