package com.air.pollution.service.impl;

import com.air.pollution.entity.City;
import com.air.pollution.repository.CityRepository;
import com.air.pollution.service.CityService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private static final Logger LOG = LogManager.getLogger(CityServiceImpl.class);
    private final CityRepository cityRepository;

    @Override
    public Optional<City> findCityByName(String name) {
        return cityRepository.findById(name);
    }

    @Override
    public Optional<City> saveCity(City city) {
        LOG.info("City saving: " + city);
        return Optional.of(cityRepository.save(city));
    }
}
