package com.air.pollution.service;

import com.air.pollution.dto.SearchResponseDto;

public interface AirPollutionService {
    SearchResponseDto getAirPollutionsBySearchParams(String city, String startDate, String endDate);

    void addCity(String cityName);

    void deleteAirPollution(String id);
}
