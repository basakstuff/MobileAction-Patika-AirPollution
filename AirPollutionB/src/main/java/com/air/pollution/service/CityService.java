package com.air.pollution.service;

import com.air.pollution.entity.City;

import java.util.Optional;

public interface CityService {

    Optional<City> findCityByName(String name);

    Optional<City> saveCity(City city);

}
