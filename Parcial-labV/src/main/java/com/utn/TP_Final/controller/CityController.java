package com.utn.TP_Final.controller;

import com.utn.TP_Final.model.City;
import com.utn.TP_Final.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("")
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;


    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/")
    public void addCity(@RequestBody City newCity)
    {
        cityService.addCity(newCity);
    }

    @GetMapping("/")
    public List<City> getAll(@RequestParam(required = false)String name)
    {
        return cityService.getAll(name);
    }

    @GetMapping("/getById/{id}")
    public Optional<City> getById(@RequestParam(required = true)Integer id)
    {
        return cityService.getById(id);
    }

    @GetMapping("/getByPrefix/{prefix}")
    public City getByPrefix(@RequestParam(required = true)String prefix)
    {
        return cityService.getByPrefix(prefix);
    }
}
