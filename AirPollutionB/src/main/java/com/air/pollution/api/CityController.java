package com.air.pollution.api;

import com.air.pollution.entity.City;
import com.air.pollution.service.AirPollutionService;
import com.air.pollution.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;
    private final AirPollutionService airPollutionService;

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        Optional<City> cityResponse = cityService.saveCity(city);
        return cityResponse.map(value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/get")
    public ResponseEntity<Void> addCities(@RequestParam(value = "city") String city) {
        airPollutionService.addCity(city);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
