package com.utn.TP_Final.service;


import com.utn.TP_Final.model.Country;
import com.utn.TP_Final.repository.CountryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CountryServiceTest {

    @Autowired
    CountryService countryService;

    @Mock
    CountryRepository countryRepository;

    @Before
    public void setUp()
    {
        initMocks(this);
        countryService = new CountryService(countryRepository);
    }

    @Test
    public void getAllTest()
    {
        List<Country> countries = new ArrayList<Country>();
        Country country1 = new Country("Argentina");
        Country country2 = new Country("Bolivia");

        countries.add(country1);
        countries.add(country2);

        when(countryRepository.findAll()).thenReturn(countries);

        List<Country> countryList = countryService.getAll(null);

        assertEquals(2, countryList.size());
        verify(countryRepository, times(1)).findAll();
    }

}
