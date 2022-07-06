package com.air.pollution.service;

import com.air.pollution.entity.City;
import com.air.pollution.pojo.response.AirPollutionResponse;
import com.air.pollution.pojo.response.CityResponse;

public interface OpenWeatherService {

    CityResponse[] getCityInformation(String cityName);

    AirPollutionResponse getAirPollutionByCityAndBetweenTwoDates(City city, Integer startDate, Integer endDate);

}
